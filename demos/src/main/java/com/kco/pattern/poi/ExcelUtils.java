package com.kco.pattern.poi;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
public class ExcelUtils {
    /**
     * 创建工作簿
     * @param sheetName sheet名称
     * @param obj       数据
     * @param columnName 标题
     * @param createRow 创建行接口
     * @param <T>       数据类型
     * @return  工作簿
     */
    public static <T> Workbook createWorkBook(String sheetName, List<T> obj, String columnName[], CreateRow<T> createRow){
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet(sheetName);
        createRow.setColumnWidth(sheet, columnName.length);

        Row headRow = sheet.createRow(0);
        createRow.configHeadRowStyle(headRow);

        Font headFont = wb.createFont();
        CellStyle headCellStyle = wb.createCellStyle();
        createRow.configHeadRowCellStyle(headFont, headCellStyle);

        Font rowFont = wb.createFont();
        CellStyle oddCellStyle = wb.createCellStyle();
        CellStyle evenCellStyle = wb.createCellStyle();
        createRow.configRowCellStyle(rowFont, oddCellStyle, evenCellStyle);

        for (int i = 0; i < columnName.length; i ++){
            Cell cell = headRow.createCell(i);
            cell.setCellValue(columnName[i]);
            cell.setCellStyle(headCellStyle);
        }

        for (int i = 1; i <= obj.size(); i ++){
            Row row = sheet.createRow(i);
            createRow.configRowStyle(i, row);
            createRow.writeRow(row, obj.get(i - 1));
            for (int j = 0; j < row.getLastCellNum(); j ++){
                row.getCell(j).setCellStyle((i % 2 == 0) ? evenCellStyle : oddCellStyle);
            }
        }
        return wb;
    }

    /**
     * 解析导入的电子表格
     * @param in            输入流
     * @param contentType   文件类型
     * @param errors        错误信息
     * @param translateRow  转换接口
     * @param <T>           数据类型
     * @return 解析的数据集合
     */
    public static <T> List<T> parseWorkbook(InputStream in, String contentType,List<ExcelErrorMsgBean> errors, TranslateRow<T> translateRow){
        try {

            Workbook wb = null;
            if (StringUtils.equalsIgnoreCase("application/vnd.ms-excel", contentType)){
                wb = new HSSFWorkbook(in);
            }else if(StringUtils.equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", contentType)){
                wb = new XSSFWorkbook(in);
            }else{
                errors.add(new ExcelErrorMsgBean(-1, -1, "上传文件格式不正确"));
                return null;
            }
            Sheet sheet = wb.getSheet("template");
            if (sheet == null){
                errors.add(new ExcelErrorMsgBean(-1, -1, "找不到对应sheet,请使用模板进行上传"));
                wb.close();
                return null;
            }

            int len = sheet.getLastRowNum();
            if (len <= 0){
                errors.add(new ExcelErrorMsgBean(-1, -1, "该sheet没有数据"));
                return null;
            }
            if (len > 200){
                errors.add(new ExcelErrorMsgBean(-1, -1, "最多只能导入200条数据,请分批导入"));
                return null;
            }
            List<T> resultList = new ArrayList<T>();
            for (int i = 1; i <= len; i ++){
                Row row = sheet.getRow(i);
                if (row == null){
                    errors.add(new ExcelErrorMsgBean(i + 1, -1, String.format("第%d行为空!", i + 1)));
                }else{
                    T result = translateRow.translate(row, i, errors);
                    if (result != null){
                        resultList.add(result);
                    }
                }
            }
            return resultList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
