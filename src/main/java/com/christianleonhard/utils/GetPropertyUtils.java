package com.christianleonhard.utils; /**
 * @Program: utils
 * @Description:
 * @Author: Li Lin
 * @Date:Create：in 2020-01-08 10:37
 * @Modified By：
 */

/**
 * @Program: utils
 * @Description: 获取系统信息工具
 * @Author: Li Lin
 * @Create: 2020-01-08 10:37
 **/
public class GetPropertyUtils {
    public static String getJavaVersion() {
        String str1 = "java版本号：" + System.getProperty("java.version"); // java版本号
        return str1;
    }

    public static String getJavaVendor() {
        String str2 = "Java提供商名称：" + System.getProperty("java.vendor"); // Java提供商名称
        return str2;
    }

    public static String getJavaVendorUrl() {
        String str3 = "Java提供商网站：" + System.getProperty("java.vendor.url"); // Java提供商网站
        return str3;
    }

    public static String getJavaHome() {
        String str4 = "jre目录：" + System.getProperty("java.home"); // Java，哦，应该是jre目录
        return str4;
    }

    public static String getJavaVmSpecificationVersion() {
        String str5 = "Java虚拟机规范版本号：" + System.getProperty("java.vm.specification.version"); // Java虚拟机规范版本号
        return str5;
    }

    public static String getJavaVmSpecificationVendor() {
        String str6 = "Java虚拟机规范提供商：" + System.getProperty("java.vm.specification.vendor"); //Java虚拟机规范提供商
        return str6;
    }

    public static String getJavaVmSpecificationName() {
        String str7 = "Java虚拟机规范名称：" + System.getProperty("java.vm.specification.name"); //Java虚拟机规范名称
        return str7;
    }

    public static String getJavaVmVersion() {
        String str8 = "Java虚拟机版本号：" + System.getProperty("java.vm.version"); // Java虚拟机版本号
        return str8;
    }

    public static String getJavaVmVendor() {
        String str9 = "Java虚拟机提供商：" + System.getProperty("java.vm.vendor"); // Java虚拟机提供商
        return str9;
    }

    public static String getJavaVmName() {
        String str10 = "Java虚拟机名称：" + System.getProperty("java.vm.name"); // Java虚拟机名称
        return str10;
    }

    public static String getJavaSpecificationVersion() {
        String str11 = "Java规范版本号：" + System.getProperty("java.specification.version"); // Java规范版本号
        return str11;
    }

    public static String getJavaSpecificationVendor() {
        String str12 = "Java规范提供商：" + System.getProperty("java.specification.vendor"); // Java规范提供商
        return str12;
    }

    public static String getJavaSpecificationName() {
        String str13 = "Java规范名称：" + System.getProperty("java.specification.name"); // Java规范名称
        return str13;
    }

    public static String getJavaClassVersion() {
        String str14 = "Java类版本号：" + System.getProperty("java.class.version"); // Java类版本号
        return str14;
    }

    public static String getJavaClassPath() {
        String str15 = "Java类路径：" + System.getProperty("java.class.path"); // Java类路径
        return str15;
    }

    public static String getJavaLibraryPath() {
        String str16 = "Java lib路径：" + System.getProperty("java.library.path"); // Java lib路径
        return str16;
    }

    public static String getJavaIoTmpdir() {
        String str17 = "Java输入输出临时路径：" + System.getProperty("java.io.tmpdir"); // Java输入输出临时路径
        return str17;
    }

    public static String getJavaCompiler() {
        String str18 = "Java编译器：" + System.getProperty("java.compiler"); // Java编译器
        return str18;
    }

    public static String getJavaExtDirs() {
        String str19 = "Java执行路径：" + System.getProperty("java.ext.dirs"); // Java执行路径
        return str19;
    }

    public static String getOsName() {
        String str20 = "操作系统名称：" + System.getProperty("os.name"); // 操作系统名称
        return str20;
    }

    public static String getOsArch() {
        String str21 = "操作系统的架构：" + System.getProperty("os.arch"); // 操作系统的架构
        return str21;
    }

    public static String getOsVersion() {
        String str22 = "操作系统版本号：" + System.getProperty("os.version"); // 操作系统版本号
        return str22;
    }

    public static String getFileSeparator() {
        String str23 = "文件分隔符：" + System.getProperty("file.separator"); // 文件分隔符
        return str23;
    }

    public static String getPathSeparator() {
        String str24 = "路径分隔符：" + System.getProperty("path.separator"); // 路径分隔符
        return str24;
    }

    public static String getLineSeparator() {
        String str25 = "直线分隔符：" + System.getProperty("line.separator"); // 直线分隔符
        return str25;
    }

    public static String getUserName() {
        String str26 = "操作系统用户名：" + System.getProperty("user.name"); // 用户名
        return str26;
    }

    public static String getUserHome() {
        String str27 = "操作系统用户的主目录：" + System.getProperty("user.home"); // 用户的主目录
        return str27;
    }

    public static String getUserDir() {
        String str28 = "当前程序所在目录：" + System.getProperty("user.dir"); // 当前程序所在目录
        return str28;
    }
}