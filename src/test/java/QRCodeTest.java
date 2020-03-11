/**
 * @Program: utils
 * @Description:
 * @Author: Li Lin
 * @Date:Create：in 2020-01-08 10:37
 * @Modified By：
 */

import com.christianleonhard.utils.QR_Code.QrcodeUtils;
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
        byte[] qrcode = QrcodeUtils.createQrcode(str, null);
        File qrcodeToFile = QrcodeUtils.createQrcodeToFile(str, null);
        String qrcodeToFilePath = QrcodeUtils.createQrcodeToFilePath(str, null);
        System.out.println(qrcodeToFilePath);
        String qrcodeToFileAbsolutePath = QrcodeUtils.createQrcodeToFileAbsolutePath(str, null);
        System.out.println(qrcodeToFileAbsolutePath);
        String qrcodeToFileCanonicalPath = QrcodeUtils.createQrcodeToFileCanonicalPath(str, null);
        System.out.println(qrcodeToFileCanonicalPath);

    }

}
