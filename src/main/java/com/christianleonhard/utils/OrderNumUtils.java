package com.christianleonhard.utils;
/**
 * @Program: utils
 * @Description:
 * @Author: Li Lin
 * @Date:Create：in 2020-01-09 09:42
 * @Modified By：
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @Program: utils
 * @Description: 订单号生成工具
 * @Author: Li Lin
 * @Create: 2020-01-09 09:42
 **/
public class OrderNumUtils {
    /**
     * @return
     * @Description: 根据UUID生成
     */
    public static String getOrderIdByUUId() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
    //0 代表前面补充0
    //4 代表长度为4
    //d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }

    /**
     * @return
     * @Description: 根据时间+随机数生成
     */
    public static String getOrderIdByTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            result += random.nextInt(10);
        }
        return newDate + result;
    }
}
