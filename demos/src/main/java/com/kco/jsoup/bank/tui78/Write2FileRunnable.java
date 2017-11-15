package com.kco.jsoup.bank.tui78;

import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by lvsw on 2017/11/15.
 */
public class Write2FileRunnable implements Runnable {
    private File file;
    private BlockingQueue<BankBean> queue;
    public Write2FileRunnable(File file, BlockingQueue<BankBean> queue){
        this.file = file;
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            while (true){
                BankBean poll = queue.poll(10, TimeUnit.SECONDS);
                if (poll == null){
                    return;
                }
                FileUtils.write(file, poll.toString(),"utf-8", true);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
