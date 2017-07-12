package com.kco.rediscache.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kco.rediscache.bean.TestBean;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试数据访问层
 * Created by Administrator on 2017/6/23.
 */
@Repository
public class TestDao {
    private static File file = new File("testBean.json");
    private static Gson gson = new Gson();


    private List<TestBean> readListFromFile(){

        try {
            String content = FileUtils.readFileToString(file, Charset.defaultCharset());
            if (StringUtils.isNotBlank(content)){
                Type type = new TypeToken<List<TestBean>>() {}.getType();
                return gson.fromJson(content, type);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
    private void writeListFromFile(List<TestBean> list){

        try {
            if (CollectionUtils.isEmpty(list)){
                return;
            }
            FileUtils.write(file, gson.toJson(list), Charset.defaultCharset());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void add(TestBean bean) {
        if (bean == null) return;
        List<TestBean> testBeans = readListFromFile();
        if (CollectionUtils.isEmpty(testBeans)){
            testBeans = new ArrayList<>();
        }
        testBeans.add(bean);
        writeListFromFile(testBeans);
    }

    public void delete(String id) {
        List<TestBean> testBeans = readListFromFile();
        if (CollectionUtils.isEmpty(testBeans)){
            return;
        }
        for (int i = 0; i < testBeans.size(); i ++){
            if (StringUtils.equals(testBeans.get(i).getId(), id)){
                testBeans.remove(i);
                return;
            }
        }
        writeListFromFile(testBeans);
    }

    public void update(TestBean bean) {
        if (bean == null) return;
        List<TestBean> testBeans = readListFromFile();
        if (CollectionUtils.isEmpty(testBeans)){
            return;
        }
        for (int i = 0; i < testBeans.size(); i ++){
            if (StringUtils.equals(testBeans.get(i).getId(), bean.getId())){
                testBeans.set(i, bean);
                return;
            }
        }
        writeListFromFile(testBeans);
    }

    public TestBean get(String id) {
        List<TestBean> testBeans = readListFromFile();
        for (int i = 0; i < testBeans.size(); i ++){
            if (StringUtils.equals(testBeans.get(i).getId(), id)){
                return testBeans.get(i);
            }
        }
        return null;
    }

    public List<TestBean> list() {
        return readListFromFile();
    }
}
