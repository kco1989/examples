package com.kco.jsoup.threedm;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by 666666 on 2017/11/10.
 */
public class PaserUrlWorker {
    private String baseFilePath;
    private List<UrlBean> urls;
    private BlockingQueue<String> queue;
    private ExecutorService paserUrlPool;
    private ExecutorService writeImgPool;


    public PaserUrlWorker(String baseFilePath, List<UrlBean> urls) {
        this.baseFilePath = baseFilePath;
        this.urls = urls;
        this.queue = new LinkedBlockingDeque<>();
        this.paserUrlPool = Executors.newFixedThreadPool(this.urls.size());
        this.writeImgPool = Executors.newFixedThreadPool(this.urls.size() * 2);
    }

    public void start(){
        for (UrlBean urlBean : urls){
            writeImgPool.execute(new WriteImgRunnable(this.baseFilePath, this.queue, this.paserUrlPool));
            writeImgPool.execute(new WriteImgRunnable(this.baseFilePath, this.queue, this.paserUrlPool));
            paserUrlPool.execute(new PaserUrlRunnable(this.baseFilePath, urlBean, this.queue));
        }
        paserUrlPool.shutdown();

    }
}
