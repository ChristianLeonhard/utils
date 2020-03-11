/**
 * @Program: utils
 * @Description:
 * @Author: Li Lin
 * @Date:Create：in 2020-01-14 15:06
 * @Modified By：
 */

import com.christianleonhard.utils.IdCardGenerate;
import java.util.Scanner;

/**
 * @Program: utils
 * @Description: 身份证号第18位生成
 * @Author: Li Lin
 * @Create: 2020-01-14 15:06
 **/
public class IdCardGenerateTest {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入身份证号码前17位：");
            String IdCard = new String(sc.next());
            if(IdCard.length()!=17){
                System.out.println("输入有误，请重新输入");
                continue;
            }
            String str18 = IdCardGenerate.verifyId(IdCard);
            System.out.println("请输入身份证号码第18位为：" + str18);
        }
    }
}
