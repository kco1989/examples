package com.kco.others;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将数据库导出的sql数据,改为批量插入
 * Created by Administrator on 2017/6/9.
 */
public class OneInsert2BatchInsertSql {
    public static String basePath = "D:\\用户目录\\我的文档\\Tencent Files\\568877100\\FileRecv\\新建文件夹(1)\\1706101431\\";
    public static final int BATCH_MAX_NUMBER = 500;
    public static void main(String[] args) throws Exception {

        File baseFile = new File(basePath);
        File[] files = baseFile.listFiles();
        for (File file : files){
            if (file.getName().endsWith("sql")){
                System.out.println(file.getName());
                replaceFile(file.getName());
            }
        }

    }

    private static void replaceFile(String path) throws Exception {
        File file = new File(basePath + path);
        if (!file.exists()){
            System.out.println(file.getName() + " 不存在.");
            return;
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(basePath + "bak/" + path));
        String line = "";
        boolean isFind = false;
        String qianzhun = "";
        List<String> sqlList = new ArrayList<>();
        while ((line = br.readLine()) != null){
            if (!line.startsWith("INSERT INTO")){
                bw.write(line + "\n");
                continue;
            }

            if (!isFind){
                Pattern compile = Pattern.compile("^(INSERT INTO.*?VALUES).*$");
                Matcher matcher = compile.matcher(line);
                if (matcher.matches()){
                    qianzhun = matcher.group(1);
                }
                isFind = true;
            }
            sqlList.add(line);
            if (sqlList.size() == BATCH_MAX_NUMBER){
                dealWithSql(sqlList, qianzhun, bw);
                sqlList.clear();
            }
        }
        if (!sqlList.isEmpty()){
            dealWithSql(sqlList,qianzhun, bw);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dealWithSql(List<String> sqlList, String qianzhun, BufferedWriter bw) throws IOException {
        bw.write(sqlList.get(0).replace(";",",") + "\n");
        for (int i = 1; i < sqlList.size() - 1; i ++){
            bw.write(sqlList.get(i).replace(qianzhun,"").replace(";",",") + "\n");
        }
        bw.write(sqlList.get(sqlList.size() - 1).replace(qianzhun, "") + "\n");
        bw.flush();
    }
}
