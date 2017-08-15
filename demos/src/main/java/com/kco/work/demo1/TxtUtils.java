package com.kco.work.demo1;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/24.
 */
public class TxtUtils {

    public static void main(String[] args) {

    }
    public static ShareParam parseWorkbook(String filePath) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        br.readLine();  // 第一行不需要
        String param = br.readLine();
        ShareParam shareParam = new ShareParam();
        parse2ndRow(param, shareParam);
        br.readLine();  // 第三行不需要
        String line = "";
        while ((line = br.readLine()) != null) {
            if (StringUtils.isBlank(line)){
                continue;
            }
            shareParam.addAgentList(line);
        }
        return shareParam;
    }


    private static void parse2ndRow(String param, ShareParam shareParam) {
        if (StringUtils.isBlank(param) || param.split("\\s+").length != 8){
            throw new IllegalArgumentException("文件格式有问题");
        }
        String[] paramArray = param.trim().split("\\s+");
        int index = 0;
        shareParam.setTransServiceId(paramArray[index ++]);
        shareParam.setTransShare(paramArray[index ++]);
        shareParam.setTransCard(StringUtils.equals(paramArray[index ++], "区分"));
        shareParam.setTransHoliday(StringUtils.equals(paramArray[index ++], "区分"));
        shareParam.setCashServiceId(paramArray[index ++]);
        shareParam.setCashShare(paramArray[index ++]);
        shareParam.setCashCard(StringUtils.equals(paramArray[index ++], "区分"));
        shareParam.setCashHoliday(StringUtils.equals(paramArray[index ++], "区分"));
    }
}
