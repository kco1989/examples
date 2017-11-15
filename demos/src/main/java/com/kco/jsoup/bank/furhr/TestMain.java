package com.kco.jsoup.bank.furhr;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by lvsw on 2017/11/15.
 */
public class TestMain {
    public static void main(String[] args) throws Exception {
        String baseUrl = "http://furhr.com/?page=%s";
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("furhr.txt")));
        for(int i = 1; i <= 6174; i ++){
            paserUrl(baseUrl, i, bw);
        }
        bw.close();
    }

    private static void paserUrl(String baseUrl, int pageNo, BufferedWriter bw) throws IOException {
        Document parse = Jsoup.connect(String.format(baseUrl, pageNo)).execute().parse();
        Elements tr = parse.select("tr");
        for(int i = 5; i < tr.size(); i ++){
            Elements tds = tr.get(i).select("td");
            for (Element td : tds){
                bw.write(td.text() + "|");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
