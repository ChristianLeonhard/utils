package com.christianleonhard.utils.QR_Code;
/**
 * @Program: utils
 * @Description:
 * @Author: MarcoWatermelon
 * @Date:Create：in 2019-11-27 10:56
 * @Modified By：
 */

import java.awt.*;

/**
 * @Program: utils
 * @Description: 二维码生成工具
 * @Author: MarcoWatermelon
 * @Create: 2019-11-27 10:56
 **/
public class MatrixToLogoImageConfig {
  //logo默认边框颜色
  public static final Color DEFAULT_BORDERCOLOR = Color.RED;
  //logo默认边框宽度
  public static final int DEFAULT_BORDER = 2;
  //logo大小默认为照片的1/5
  public static final int DEFAULT_LOGOPART = 5;

  private final int border = DEFAULT_BORDER;
  private final Color borderColor;
  private final int logoPart;

  public MatrixToLogoImageConfig() {
    this(DEFAULT_BORDERCOLOR, DEFAULT_LOGOPART);
  }

  public MatrixToLogoImageConfig(Color borderColor, int logoPart) {
    this.borderColor = borderColor;
    this.logoPart = logoPart;
  }

  public Color getBorderColor() {
    return this.borderColor;
  }

  public int getBorder() {
    return this.border;
  }

  public int getLogoPart() {
    return this.logoPart;
  }
}
