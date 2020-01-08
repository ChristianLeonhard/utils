/**
 * @Program: utils
 * @Description:
 * @Author: Li Lin
 * @Date:Create：in 2020-01-08 10:37
 * @Modified By：
 */

import com.christianleonhard.utils.QrcodeUtils;

import java.io.File;

/**
 * @Program: utils
 * @Description:
 * @Author: Li Lin
 * @Create: 2020-01-08 10:37
 **/
public class QRCodeTest {
    public static void main(String[] args) {
        String str = "https://www.baidu.com/";
        QrcodeUtils.createQrcode(str, 200,null);
    }
}
