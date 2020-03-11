package com.christianleonhard.utils;
/**
 * @Program: utils
 * @Description:
 * @Author: Li Lin
 * @Date:Create：in 2020-01-14 14:21
 * @Modified By：
 */

/**
 * @Program: utils
 * @Description: 身份证第18位生成
 * @Author: Li Lin
 * @Create: 2020-01-14 14:21
 **/
public class IdCardGenerate {
    /**
     * 身份证第18位生成
     *
     * @param id
     * @return
     */
    public static String verifyId(String id) {
        int count = 0;
        char[] charArr = id.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            int n = Integer.parseInt(charArr[i] + "");
            count += n * (Math.pow(2, 17 - i) % 11);
        }
        switch (count % 11) {
            case 0:
                return "1";
            case 1:
                return "0";
            case 2:
                return "X";
            default:
                return 12 - (count % 11) + "";
        }
    }
}
