/**
 * @Program: utils
 * @Description:
 * @Author: MarcoWatermelon
 * @Date:Create：in 2020-03-05 20:30
 * @Modified By：
 */

import com.christianleonhard.utils.GetPinYin;

/**
 * @Program: utils
 * @Description:
 * @Author: MarcoWatermelon
 * @Create: 2020-03-05 20:30
 **/
public class PinyinTest {
    public static void main(String[] args) {
        System.out.println(GetPinYin.getPinYin("阿里巴巴"));
        System.out.println(GetPinYin.getPinYinHeadChar("阿里巴巴"));
    }
}
