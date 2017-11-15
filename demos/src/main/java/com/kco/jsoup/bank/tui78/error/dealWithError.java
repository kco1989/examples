package com.kco.jsoup.bank.tui78.error;

import com.kco.jsoup.bank.tui78.BankBean;
import com.kco.jsoup.bank.tui78.CityBankRunnable;
import com.kco.jsoup.bank.tui78.Write2FileRunnable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by lvsw on 2017/11/15.
 */
public class dealWithError {
    public static void main(String[] args) throws Exception {
        File file = new File("bank/errorCity1.log");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        BlockingQueue<BankBean> queue = new LinkedBlockingQueue<>();
        while ((line = br.readLine()) != null){
            String[] split = line.split("\t");
            String city = split[1];
            String bank = split[2];
            String url = split[3];
            System.out.println(url);
            new Thread(new CityBankRunnable(url, city, bank, queue)).start();
        }
        new Thread(new Write2FileRunnable(new File("bank/errorBank.txt"), queue)).start();
        br.close();
    }
}
