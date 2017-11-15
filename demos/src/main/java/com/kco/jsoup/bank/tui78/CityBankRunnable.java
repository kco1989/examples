package com.kco.jsoup.bank.tui78;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

/**
 * Created by lvsw on 2017/11/15.
 */
public class CityBankRunnable implements Runnable {
    private String cityName;
    private String cityBankUrl;
    private String title;
    private BlockingQueue<BankBean> queue;
    public CityBankRunnable(String cityBankUrl, String cityName, String title,BlockingQueue<BankBean> queue){
        this.cityBankUrl = cityBankUrl;
        this.cityName = cityName;
        this.title = title;
        this.queue = queue;
    }


    @Override
    public void run() {
        System.out.println("start " + this.title + " --> " + this.title);
        try {
            Document parse = Jsoup.connect(this.cityBankUrl).execute().parse();
            Elements lis = parse.select("#bank li");
            for (int i = 1; i < lis.size(); i ++){
                Elements spans = lis.get(i).select("span");
                BankBean bankBean = new BankBean();
                bankBean.title = this.title;
                bankBean.cityName = cityName;
                bankBean.bankName = spans.get(0).text();
                bankBean.bankNo = spans.get(1).select("b").first().text();
                bankBean.address = spans.get(2).text();
                queue.put(bankBean);
            }
        } catch (Exception e) {
            try {
                FileUtils.write(new File("bank/errorCity.log"), "city: \t" + this.cityName + "\t" + title + "\t" + this.cityBankUrl + "\n","utf-8", true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        System.out.println("end " + this.title + " --> " + this.title);
    }
}
