/**
 * @Program: utils
 * @Description:
 * @Author: Li Lin
 * @Date:Create：in 2020-01-14 14:25
 * @Modified By：
 */

import com.christianleonhard.utils.IdCardVerification;

import java.text.ParseException;
import java.util.Scanner;

/**
 * @Program: utils
 * @Description: 身份证号有效性测试
 * @Author: Li Lin
 * @Create: 2020-01-14 14:25
 **/
public class IdCarCheckTest {
    public static void main(String[] args) throws ParseException {
        while (true) {
            // 从控制端输入用户身份证
            Scanner s = new Scanner(System.in);
            System.out.println("请输入你的身份证号码：");
            String IdCard = new String(s.next());
            // 将身份证最后一位的x转换为大写，便于统一
            String ID = IdCard.toUpperCase();
            System.out.println(IdCardVerification.IDCardValidate(ID));
        }
    }
}
