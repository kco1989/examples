package com.kco;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.weaver.ast.Or;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Administrator on 2017/7/13.
 */
public class test {
//    private static final String path = "C:\\Users\\666666\\Desktop\\weiqibaodian_390\\assets\\weiqi\\misc\\exam\\wytesuji";
//    private static final Map<String, Integer> map = new HashMap<>();
//
//    public static void main(String[] args) throws IOException {
//        File baseFile = new File(path);
//        File[] files = baseFile.listFiles(file->file.getAbsolutePath().endsWith("sgf"));
//        for (File file : files){
//            String string = FileUtils.readFileToString(file);
//            toMap(string);
//        }
//        System.out.println(map);
//    }
//    public static void toMap(String str){
//        for (Character ch : str.toCharArray()){
//            Integer integer = map.get(ch + "");
//            if (integer == null){
//                map.put(ch + "", 1);
//            }else{
//                map.put(ch + "", integer + 1);
//            }
//        }
//    }
//
//    public static class BossInfo{
//        private List<Data> result;
//
//        public List<Data> getResult() {
//            return result;
//        }
//
//        public void setResult(List<Data> result) {
//            this.result = result;
//        }
//    }
//    public static class MerchantInfo{
//        private String message;
//        private boolean success;
//        private List<Data> data;
//        private int count;
//
//        public String getMessage() {
//            return message;
//        }
//
//        public void setMessage(String message) {
//            this.message = message;
//        }
//
//        public boolean isSuccess() {
//            return success;
//        }
//
//        public void setSuccess(boolean success) {
//            this.success = success;
//        }
//
//        public List<Data> getData() {
//            return data;
//        }
//
//        public void setData(List<Data> data) {
//            this.data = data;
//        }
//
//        public int getCount() {
//            return count;
//        }
//
//        public void setCount(int count) {
//            this.count = count;
//        }
//    }
//    public static class Data{
//        private String id;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            Data data = (Data) o;
//
//            return id != null ? id.equals(data.id) : data.id == null;
//        }
//
//        @Override
//        public int hashCode() {
//            return id != null ? id.hashCode() : 0;
//        }
//    }
//    public static void main(String[] args) throws Exception {
//        String agent = "C:\\Users\\666666\\Desktop\\新建文件夹\\agent.txt";
//        String boss = "C:\\Users\\666666\\Desktop\\新建文件夹\\boss.txt";
//        Gson gson = new Gson();
//        MerchantInfo agentInfo = gson.fromJson(FileUtils.readFileToString(new File(agent)), MerchantInfo.class);
//        BossInfo bossInfo = gson.fromJson(FileUtils.readFileToString(new File(boss)), BossInfo.class);
//        Map<String, Integer> agentInfoMap = new HashMap<>();
//        Map<String, Integer> bossInfoMap = new HashMap<>();
//        for (Data bossData : agentInfo.getData()){
//            Integer temp = agentInfoMap.get(bossData.getId());
//            if (temp == null){
//                agentInfoMap.put(bossData.getId(), 1);
//            }else {
//                agentInfoMap.put(bossData.getId(), temp + 1);
//            }
//        }
//        for (Data bossData : bossInfo.getResult()){
//            Integer temp = bossInfoMap.get(bossData.getId());
//            if (temp == null){
//                bossInfoMap.put(bossData.getId(), 1);
//            }else {
//                bossInfoMap.put(bossData.getId(), temp + 1);
//            }
//        }
//        System.out.println(agentInfoMap);
//        System.out.println(agentInfoMap.size());
//        System.out.println(agentInfo.getData().size());
//        System.out.println("====================");
//        System.out.println(bossInfoMap);
//        System.out.println(bossInfoMap.size());
//        System.out.println(bossInfo.getResult().size());
//    }
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(".48");
        BigDecimal bigDecimal2 = new BigDecimal(".535");
        System.out.println(bigDecimal2.setScale(2, BigDecimal.ROUND_CEILING));
        System.out.println(bigDecimal.compareTo(bigDecimal2));
    }
}

