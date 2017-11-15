package com.kco.jsoup.bank.tui78;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.awt.windows.ThemeReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.*;

/**
 * Created by lvsw on 2017/11/15.
 */
public class BankRunnable implements Runnable {
    private String baseFilePath;
    private String baseUrl;
    private String name;
    private ExecutorService pool;
    private BlockingQueue<BankBean> queue;

    public BankRunnable(String baseFilePath, String baseUrl, String name) throws IOException {
        this.baseFilePath = baseFilePath;
        this.baseUrl = baseUrl;
        this.name = name;
        this.pool = Executors.newFixedThreadPool(20);
        this.queue = new LinkedBlockingQueue<>();
    }
    @Override
    public void run() {
        System.out.println(this.name);
        try {
            Document parse = Jsoup.connect(this.baseUrl).execute().parse();
            Elements as = parse.select(".weizhi ul a");
            for (Element a : as){
                pool.execute(new CityBankRunnable(a.attr("abs:href"), a.text(), a.attr("title"), queue));
            }
            new Thread(new Write2FileRunnable(new File(baseFilePath + name + ".txt"), queue)).start();
            pool.shutdown();
        } catch (IOException e) {
            try {
                FileUtils.write(new File("bank/errorBank.log"), "bank: \t" + name + "\t" + this.baseUrl + "\n","utf-8", true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}
