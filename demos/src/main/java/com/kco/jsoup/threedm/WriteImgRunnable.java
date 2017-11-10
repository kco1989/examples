package com.kco.jsoup.threedm;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

/**
 * Created by 666666 on 2017/11/9.
 */
public class WriteImgRunnable implements Runnable{
    private String baseFilePath;
    private BlockingQueue<String> queue;
    private ExecutorService pool;

    public WriteImgRunnable(String baseFilePath, BlockingQueue<String> queue, ExecutorService pool) {
        this.baseFilePath = baseFilePath;
        this.queue = queue;
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            writeImg();
        }catch (Exception e){

        }

    }

    private void writeImg() throws Exception {
        while (true){
            String poll = queue.take();
            if (StringUtils.equals(poll, "over")){
                this.pool.shutdownNow();
                return;
            }
            CloseableHttpResponse execute = HttpClients.createDefault().execute(new HttpGet(poll));
            System.out.println("--> " + poll + " <====> " + queue.size());
            String fileName = poll.replaceAll("http://", "");
            FileUtils.copyInputStreamToFile(execute.getEntity().getContent(), new File(baseFilePath + fileName));
        }
    }

}
