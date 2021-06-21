package com.christianleonhard.utils;
/**
 * @Program: utils
 * @Description:
 * @Author: MarcoWatermelon
 * @Date:Create：in 2020-01-09 09:24
 * @Modified By：
 */

import com.alibaba.com.caucho.hessian.io.HessianInput;
import com.alibaba.com.caucho.hessian.io.HessianOutput;
import org.apache.commons.lang3.ArrayUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @Program: utils
 * @Description: 序列化工具类，基于hessian
 * @Author: MarcoWatermelon
 * @Create: 2020-01-09 09:24
 **/
public class SerializeUtils {
    /**
     * 序列化
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {
        if (object == null) {
            return null;
        }
        HessianOutput hessianOutput = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            hessianOutput = new HessianOutput(byteArrayOutputStream);
            hessianOutput.writeObject(object);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                hessianOutput.close();
                byteArrayOutputStream.close();
            } catch (Exception ex) {
            }
        }
    }

    /**
     * 反序列化
     * @param bytes
     * @param clazz
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T deserialize(byte[] bytes, Class<T> clazz) {
        if (ArrayUtils.isEmpty(bytes)) {
            return null;
        }
        HessianInput hessianOutput = null;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            hessianOutput = new HessianInput(byteArrayInputStream);
            return (T) hessianOutput.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                hessianOutput.close();
                byteArrayInputStream.close();
            } catch (Exception ex) {
            }
        }
    }
}
