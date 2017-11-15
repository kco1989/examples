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
//        urls.add(new UrlBean("基础概念及兵种建筑资料百科", "http://www.gamersky.com/handbook/201610/824112.shtml"));
//        urls.add(new UrlBean("伟人背景及科技市政资料百科","http://www.gamersky.com/handbook/201611/828925.shtml"));
//        urls.add(new UrlBean("全文明及领袖数据资料一览","http://www.gamersky.com/handbook/201610/824318.shtml"));
//        urls.add(new UrlBean("单位数据、特点百科全书","http://www.gamersky.com/handbook/201610/820440.shtml"));
//        urls.add(new UrlBean("建筑特点及背景资料大全","http://www.gamersky.com/handbook/201610/816637.shtml"));
//        urls.add(new UrlBean("伟人能力特点及背景资料百科","http://www.gamersky.com/handbook/201610/823833.shtml"));
//        urls.add(new UrlBean("奇迹数据及特点资料百科","http://www.gamersky.com/handbook/201610/819816.shtml"));
//        urls.add(new UrlBean("科技背景及解锁条件资料大全","http://www.gamersky.com/handbook/201610/819852.shtml"));
//        urls.add(new UrlBean("市政背景及解锁条件资料大全","http://www.gamersky.com/handbook/201610/821023.shtml"));
//        urls.add(new UrlBean("全科技、人文资料百科 科技树、人文树一览","http://www.gamersky.com/handbook/201610/825655.shtml"));
//        urls.add(new UrlBean("新手基础攻略 政策科技及国家领袖特点详解","http://www.gamersky.com/handbook/201701/860585.shtml"));
//        urls.add(new UrlBean("统治胜利区块规划注意事项详解 征服怎么拍地","http://www.gamersky.com/handbook/201706/913524.shtml"));
//        urls.add(new UrlBean("新手必看六大技巧图文介绍 开局怎么坐地","http://www.gamersky.com/handbook/201706/915662.shtml"));
//        urls.add(new UrlBean("生产力怎么提升 生产力基础指南与提高生产力方法","http://www.gamersky.com/handbook/201611/827903.shtml"));
//        urls.add(new UrlBean("新手指南基础篇 基本操作与概念","http://www.gamersky.com/handbook/201711/975901.shtml"));
//        urls.add(new UrlBean("全国家介绍及特性一览 各国特色介绍","http://www.gamersky.com/handbook/201608/788697.shtml"));
//        urls.add(new UrlBean("图文攻略 全系统详解及玩法图文攻略","http://www.gamersky.com/handbook/201610/824218.shtml"));
//        urls.add(new UrlBean("",""));
//        urls.add(new UrlBean("",""));
//        urls.add(new UrlBean("",""));
    }

    public static void main(String[] args) throws IOException {
        BlockingQueue<String> queue = new LinkedBlockingDeque<>();
        for (UrlBean urlBean: urls){
            new Thread(new PaserUrlRunnable(baseFilePath, urlBean, queue)).start();
            new Thread(new WriteImgRunnable(baseFilePath, queue)).start();
        }
    }
}
