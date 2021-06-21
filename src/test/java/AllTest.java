/**
 * @Program: utils
 * @Description:
 * @Author: MarcoWatermelon
 * @Date:Create：in 2020-02-10 11:37
 * @Modified By：
 */

import java.text.DecimalFormat;
import java.text.Format;

/**
 * @Program: utils
 * @Description:
 * @Author: MarcoWatermelon
 * @Create: 2020-02-10 11:37
 **/
public class AllTest {
    public static void main(String[] args) {
        int i = 1;
        Format f1 = new DecimalFormat("000");
        String format = f1.format(i);
        System.out.println(format);
    }
}
