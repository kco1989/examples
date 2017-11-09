package com.kco.jsoup.demo3;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Created by 666666 on 2017/11/9.
 */
public class WriteImgRunnable implements Runnable{
    private String baseFilePath;
    private BlockingQueue<String> queue;

    public WriteImgRunnable(String baseFilePath, BlockingQueue<String> queue) {
        this.baseFilePath = baseFilePath;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            writeImg(0);
        }catch (Exception e){

        }

    }

    private void writeImg(int i) throws Exception {
        while (true){
            String poll = queue.take();
            if (StringUtils.equals(poll, "over")){
                return;
            }
            CloseableHttpResponse execute = HttpClients.createDefault().execute(new HttpGet(poll));
            System.out.println("--> " + poll + " <====> " + queue.size());
            FileUtils.copyInputStreamToFile(execute.getEntity().getContent(), new File(baseFilePath + i + ".jpg"));
            i ++;
            Thread.sleep(50);
        }
    }

}
