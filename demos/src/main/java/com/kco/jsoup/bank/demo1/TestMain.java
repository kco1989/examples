package com.kco.jsoup.bank.demo1;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Created by 666666 on 2017/11/15.
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        Document parse = Jsoup.connect("http://www.cscse.edu.cn/publish/portal0/tab117/default.htm").execute().parse();
//        System.out.println(parse);
        Elements a = parse.select("#ess_ctr871_ListC_Info_LstC_Info a");
        for (Element e : a){
            String href = e.attr("abs:href");
            CloseableHttpResponse execute = HttpClients.createDefault().execute(new HttpGet(href));
            String fileName = href.replaceAll("http://", "");
            FileUtils.copyInputStreamToFile(execute.getEntity().getContent(), new File( fileName));
        }
    }
}
