package com.christianleonhard.utils.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: ll
 * @Desc:
 * @create: 2025-04-07 11:07:00
 **/
public class ExcelRead {

    public static void main(String[] args) {
        String excelFilePath = "D:/601939.xlsx";
        double baseNumber = 8.00; // 基数
        double rise = 0.02; // 上浮比例
        double lower = 0.01; // 下浮比例

        try {
            readAndProcessExcel(excelFilePath, baseNumber, rise, lower);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndProcessExcel(String excelFilePath, double baseNumber, double rise, double lower) throws IOException {
        FileInputStream fis = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        double br = baseNumber + (baseNumber * rise); // br 的计算公式
        double bl = baseNumber - (baseNumber * lower); // bl 的计算公式

        //System.out.println("Processing Excel file: " + excelFilePath); // 添加日志输出
        //System.out.println("Base Number: " + baseNumber + ", Rise: " + rise + ", Lower: " + lower); // 添加日志输出

        for (Row row : sheet) {
            if (row.getRowNum() < 2) { // 跳过前三行
                continue;
            }

            Cell cellA = row.getCell(0); // 获取 A 列的值
            Cell cellC = row.getCell(2);
            Cell cellD = row.getCell(3);

            if (cellA != null && cellC != null && cellD != null) {
                String valueA = cellA.getStringCellValue().trim(); // 直接获取 A 列的字符串值
                double valueC = getNumericCellValue(cellC);
                double valueD = getNumericCellValue(cellD);
                // 写入 br 到 E 列
                Cell cellE = row.getCell(4);
                if (cellE == null) {
                    cellE = row.createCell(4);
                }
                cellE.setCellValue(br);
                // 写入 bl 到 G 列
                Cell cellF = row.getCell(6);
                if (cellF == null) {
                    cellF = row.createCell(6);
                }
                cellF.setCellValue(bl);
                //StringBuffer logMessage = new StringBuffer();
                //logMessage.append(valueA).append(", 最高： ").append(valueC).append(", 最低： ").append(valueD);

                if (bl <= valueC && bl >= valueD) {
                    baseNumber = valueD; // 更新 baseNumber 为 valueD
                    //logMessage.append(", 最低买入： ").append(bl);
                    //logMessage.append(" ，最低基数为:").append(baseNumber);

                    // 写入新的 baseNumber 到 H 列
                    Cell cellG = row.getCell(7);
                    if (cellG == null) {
                        cellG = row.createCell(7);
                    }
                    cellG.setCellValue(baseNumber);
                }
                if (br <= valueC && br >= valueD) {
                    if (!(bl <= valueC && bl >= valueD)) { // 只有在第一个条件不满足时才更新 baseNumber 为 valueC
                        baseNumber = valueC; // 更新 baseNumber 为 valueC
                        //logMessage.append(", 最高卖出： ").append(br);
                        //logMessage.append(" ，最高基数为:").append(baseNumber);

                        // 写入新的 baseNumber 到 F 列
                        Cell cellG = row.getCell(5);
                        if (cellG == null) {
                            cellG = row.createCell(5);
                        }
                        cellG.setCellValue(baseNumber);
                    }
                }
                //System.out.println(logMessage.toString()); // 输出拼接后的日志信息
            }
        }

        FileOutputStream fos = new FileOutputStream(excelFilePath);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();
        //System.out.println("Excel file processed and saved successfully."); // 添加日志输出
    }

    private static double getNumericCellValue(Cell cell) {
        if (cell == null) {
            return 0; // 如果单元格为空，返回默认值 0
        }

        switch (cell.getCellType()) {
            case NUMERIC:
                return cell.getNumericCellValue(); // 直接返回数值类型的单元格值
            case STRING:
                String stringValue = cell.getStringCellValue().trim();
                if (isNumeric(stringValue)) { // 判断字符串是否为数值
                    try {
                        return Double.parseDouble(stringValue); // 如果是数值，则解析并返回
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("无法将字符串单元格转换为数值: " + stringValue, e);
                    }
                } else {
                    // 尝试将字符串转换为数值
                    try {
                        return Double.parseDouble(stringValue);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("字符串单元格不是数值: " + stringValue, e);
                    }
                }
            default:
                throw new IllegalStateException("未知的单元格类型: " + cell.getCellType());
        }
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str); // 尝试解析
            return true; // 如果成功，则是数值
        } catch (NumberFormatException e) {
            return false; // 如果失败，则不是数值
        }
    }
}
