/**
 * @Program: utils
 * @Description:
 * @Author: Li Lin
 * @Date:Create：in 2020-03-05 20:30
 * @Modified By：
 */

import com.christianleonhard.utils.GetPinYin;

/**
 * @Program: utils
 * @Description:
 * @Author: Li Lin
 * @Create: 2020-03-05 20:30
 **/
public class PinyinTest {
    public static void main(String[] args) {
        System.out.println(GetPinYin.getPinYin("颜丽玲"));
        System.out.println(GetPinYin.getPinYinHeadChar("颜丽玲"));
    }
}
