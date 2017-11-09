package com.kco.jsoup.demo4;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by 666666 on 2017/11/9.
 */
public class TuWenUtils{
    private final static String baseFilePath = "e:\\文明\\demo1\\";
    private final static String baseUrl = "http://www.gamersky.com/handbook/201610/821023.shtml";

    public static void main(String[] args) throws IOException {
        System.out.println("开始...");
        BlockingQueue<String> queue = new LinkedBlockingDeque<>();
        new Thread(new PaserUrlRunnable(baseFilePath, baseUrl, queue)).start();
        new Thread(new WriteImgRunnable(baseFilePath, queue)).start();
    }
}
