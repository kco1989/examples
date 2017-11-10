package com.kco.jsoup.threedm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by 666666 on 2017/11/9.
 */
public class TuWenUtils{
    private final static String baseFilePath = "e:\\文明\\demo2\\";
    private final static List<UrlBean> urls = new ArrayList<>();
    static {
        urls.add(new UrlBean("图文教程攻略百科 从入门到精通全方位解析", "http://www.3dmgame.com/gl/201610/3601726.html"));
    }

    public static void main(String[] args) throws IOException {
        PaserUrlWorker worker = new PaserUrlWorker(baseFilePath, urls);
        worker.start();
    }
}
