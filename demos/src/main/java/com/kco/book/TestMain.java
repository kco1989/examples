package com.kco.book;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 666666 on 2017/11/28.
 */
public class TestMain {


//    public static void main(String[] args) throws IOException {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost("http://123.207.239.247:8080/bluezone/common/login.do");
//        httpPost.addHeader("content-type", "application/json;charset=utf-8");
////        Map<String, String> param = new HashMap<>();
////        param.put("userName", "admin");
////        param.put("passwd", "123456");
////        Gson gson = new Gson();
//        httpPost.setEntity(new StringEntity("{\"userName\":\"admin\", \"passwd\":\"123456\"}", "utf-8"));
//        CloseableHttpResponse execute = httpClient.execute(httpPost);
//        System.out.println(execute.getStatusLine());
//        System.out.println(IOUtils.toString(execute.getEntity().getContent()));
//    }

    public static void main(String[] args) {

    }
}
