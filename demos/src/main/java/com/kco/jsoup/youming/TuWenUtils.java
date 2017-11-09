package com.kco.jsoup.youming;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by 666666 on 2017/11/9.
 */
public class TuWenUtils{
    private final static String baseFilePath = "e:\\文明\\demo1\\";
    private final static String baseUrl = "http://www.gamersky.com/handbook/201610/821023.shtml";
    private final static List<UrlBean> urls = new ArrayList<>();
    static {
        urls.add(new UrlBean("基础概念及兵种建筑资料百科", "http://www.gamersky.com/handbook/201610/824112.shtml"));
        urls.add(new UrlBean("伟人背景及科技市政资料百科","http://www.gamersky.com/handbook/201611/828925.shtml"));
        urls.add(new UrlBean("全文明及领袖数据资料一览","http://www.gamersky.com/handbook/201610/824318.shtml"));
        urls.add(new UrlBean("单位数据、特点百科全书","http://www.gamersky.com/handbook/201610/820440.shtml"));
        urls.add(new UrlBean("建筑特点及背景资料大全","http://www.gamersky.com/handbook/201610/816637.shtml"));
        urls.add(new UrlBean("伟人能力特点及背景资料百科","http://www.gamersky.com/handbook/201610/823833.shtml"));
        urls.add(new UrlBean("奇迹数据及特点资料百科","http://www.gamersky.com/handbook/201610/819816.shtml"));
        urls.add(new UrlBean("科技背景及解锁条件资料大全","http://www.gamersky.com/handbook/201610/819852.shtml"));
        urls.add(new UrlBean("市政背景及解锁条件资料大全","http://www.gamersky.com/handbook/201610/821023.shtml"));
    }

    public static void main(String[] args) throws IOException {
        BlockingQueue<String> queue = new LinkedBlockingDeque<>();
        for (UrlBean urlBean: urls){
            new Thread(new PaserUrlRunnable(baseFilePath, urlBean, queue)).start();
            new Thread(new WriteImgRunnable(baseFilePath, queue)).start();
        }
    }
}
