package com.christianleonhard.utils;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import io.minio.MinioClient;
import io.minio.errors.MinioException;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: ll
 * @Desc:
 * @create: 2025-04-01 08:50:58
 **/
public class MinIOUtils {
    public static void main(String[] args) {
        String endpoint = "http://10.155.95.110:9081/";
        String accessKey = "kzD67i2fddWNsCAhqOD6";
        String secretKey = "rbYXA3ZZ5u1buf9gQuMmxDTr2RqeUdZfvDs9hC4J";

        // 初始化 MinIO 客户端
        MinioClient minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();

        // 获取桶的大小
        try {
            // 生成请求MinIO的token
            final JWTSigner signer = JWTSignerUtil.hs512(secretKey.getBytes());
            Map<String, Object> payload = new HashMap<String, Object>() {
                private static final long serialVersionUID = 1L;
                {
                    put("sub", accessKey);
                    put("exp", System.currentTimeMillis() + 1000 * 60);
                    put("iss", "prometheus");
                }
            };
            String token = JWTUtil.createToken(payload, signer);

            // 请求MinIO的metrics接口
            String url = endpoint + "minio/v2/metrics/bucket";
            String result = HttpRequest.get(url)
                    .header(Header.USER_AGENT, "ANY")
                    .header("Authorization", "Bearer " + token)
                    .header("Accept", "*/*")
                    .header("Host", "10.155.95.110:9081")
                    .header("Connection", "keep-alive")
                    .execute().body();

            // 打印返回结果以便调试
            //System.out.println("返回结果: " + result);

            // 解析metric结果
            String usagePatternString = "minio_bucket_usage_total_bytes\\{bucket=\"([^\"]+)\",server=\"[^\"]+\"\\}\\s+([0-9]+(\\.[0-9]+)?([eE][-+]?[0-9]+)?)";
            Pattern usagePattern = Pattern.compile(usagePatternString);
            Matcher usageMatcher = usagePattern.matcher(result);

            double totalUsageBytes = 0; // 添加变量来累加总的使用量

            while (usageMatcher.find()) {
                String bucketName = usageMatcher.group(1);
                double usageTotalBytes = Double.parseDouble(usageMatcher.group(2));

                // 转换为可读格式
                String readableSize = convertBytesToReadableSize(usageTotalBytes);
                System.out.println("桶的名称: " + bucketName + ", 已用容量: " + readableSize);

                totalUsageBytes += usageTotalBytes; // 累加总的使用量
            }

            // 输出总的使用量
            String totalReadableSize = convertBytesToReadableSize(totalUsageBytes);
            System.out.println("总的已用容量: " + totalReadableSize);
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
        }
    }

    private static final String[] UNITS = {"B", "KB", "MB", "GB", "TB", "PB"};
    private static final int UNIT_SIZE = 1024;

    public static String convertBytesToReadableSize(double bytes) {
        if (bytes <= 0) {
            return "0 B";
        }

        int exponent = (int) (Math.log(bytes) / Math.log(UNIT_SIZE));
        // 确保指数不超过单位数组的最大索引
        exponent = Math.min(exponent, UNITS.length - 1);
        double size = bytes / Math.pow(UNIT_SIZE, exponent);
        int decimalPlaces = (size < 10) ? 1 : 0; // 如果小于10，保留一位小数，否则不保留
        String formatString = "%." + decimalPlaces + "f %s";

        return String.format(formatString, size, UNITS[exponent]);
    }
}