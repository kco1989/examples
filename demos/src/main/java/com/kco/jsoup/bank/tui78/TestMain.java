package com.kco.jsoup.bank.tui78;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lvsw on 2017/11/15.
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        String baseUrl = "http://www.tui78.com/bank/";
        Document parse = Jsoup.connect(baseUrl).execute().parse();
        Elements as = parse.select("#bank li span a");
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (Element a : as){
            executorService.execute(new BankRunnable("bank/", a.attr("abs:href"), a.text()));
        }
        executorService.shutdown();
    }
}
