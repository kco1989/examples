package com.kco.work.demo1;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
public class ExcelUtils {

    public static ShareParam parseWorkbook(String filePath){
        try {
            Workbook wb = new XSSFWorkbook(new FileInputStream(filePath));
            Sheet sheet = wb.getSheet("template");
            if (sheet == null){
                throw new IllegalArgumentException("找不到对应sheet,请使用模板进行上传");
            }

            int len = sheet.getLastRowNum();
            if (len <= 0){
                throw new IllegalArgumentException("该sheet没有数据");
            }
            ShareParam shareParam = new ShareParam();
            for (int i = 1; i <= len; i ++){
                Row row = sheet.getRow(i);
                if (i == 1){
                    parse2ndRow(row,shareParam);
                    continue;
                }
                if (i == 2){
                    continue;
                }
                parseOtherRow(row,shareParam);
            }
            return shareParam;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static void parseOtherRow(Row row, ShareParam shareParam) {
        String agentNo = row.getCell(0).toString();
        if (StringUtils.isNotBlank(agentNo)){
            shareParam.addAgentList(agentNo);
        }
    }

    private static void parse2ndRow(Row row, ShareParam shareParam) {
        int index = 0;

        shareParam.setTransServiceId(row.getCell(index ++).toString());
        shareParam.setTransShare(row.getCell(index ++).toString());
        shareParam.setTransCard(StringUtils.equals(row.getCell(index ++).toString(), "区分"));
        shareParam.setTransHoliday(StringUtils.equals(row.getCell(index ++).toString(), "区分"));
        shareParam.setCashServiceId(row.getCell(index ++).toString());
        shareParam.setCashShare(row.getCell(index ++).toString());
        shareParam.setCashCard(StringUtils.equals(row.getCell(index ++).toString(), "区分"));
        shareParam.setCashHoliday(StringUtils.equals(row.getCell(index ++).toString(), "区分"));
    }
}
