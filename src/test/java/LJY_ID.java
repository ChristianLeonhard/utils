/**
 * @Program: utils
 * @Description:
 * @Author: Li Lin
 * @Date:Create：in 2020-02-10 11:14
 * @Modified By：
 */

import com.christianleonhard.utils.IdCardGenerate;

import java.text.DecimalFormat;
import java.text.Format;

/**
 * @Program: utils
 * @Description:
 * @Author: Li Lin
 * @Create: 2020-02-10 11:14
 **/
public class LJY_ID {
    public static void main(String[] args) {
        String q14w91n = "35060019910926";
        String q14w95n = "35060019950926";
        Format f1 = new DecimalFormat("000");
        int i15_17 = 0;
        String format = f1.format(i15_17);
        for (int o = 0; o <= 499; o++) {
            String append = q14w95n + format;
            String str18 = IdCardGenerate.verifyId(append);
            if (str18.equals("3")) {
                //System.out.println("==========注意==========有符合条件的==========注意==========");
                //System.out.println("请输入身份证号码第15-17位为：" + format);
                //System.out.println("请输入身份证号码第18位为：" + str18);
                System.out.println(q14w95n + format + str18);
                //System.out.println();
            }
            int newi = Integer.parseInt(format);
            int newnewi = newi + 2;
            format = f1.format(newnewi);
            //System.out.println("请输入身份证号码第15-17位为：" + format);
            //System.out.println("请输入身份证号码第18位为：" + str18);
        }
    }
}
