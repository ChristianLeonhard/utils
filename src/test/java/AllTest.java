/**
 * @Program: utils
 * @Description:
 * @Author: MarcoWatermelon
 * @Date:Create：in 2020-02-10 11:37
 * @Modified By：
 */

import com.christianleonhard.utils.DateUtils;

/**
 * @Program: utils
 * @Description:
 * @Author: MarcoWatermelon
 * @Create: 2020-02-10 11:37
 **/
public class AllTest {
    public static void main(String[] args) {
        int differenceOnlyMonth = DateUtils.getDifferenceOnlyMonth("2023-09-26", "2023-10-24");
        System.out.println(differenceOnlyMonth);
    }
}
