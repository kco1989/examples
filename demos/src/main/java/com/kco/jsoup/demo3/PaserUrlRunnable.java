package com.kco.jsoup.demo3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by 666666 on 2017/11/9.
 */
public class PaserUrlRunnable implements Runnable{
    private String baseUrl;
    private BlockingQueue<String> queue;

    public PaserUrlRunnable(String baseUrl, BlockingQueue<String> queue) {
        this.baseUrl = baseUrl;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            paserUrl(baseUrl);
        }catch (Exception e){

        }

    }

    private void paserUrl(String url) throws Exception {
        System.out.println("===> " + url);
        Document parse = Jsoup.connect(url).execute().parse();
        Elements select = parse.select(".Mid2L_con p[align='center'] a img.picact");
        if (select != null && !select.isEmpty()){
            for (Element node : select){
                queue.put(node.attr("data-src"));
            }
        }
        Element element = parse.select("div.page_css a").last();
        if (element != null && element.text().equals("下一页")){
            paserUrl(element.attr("href"));
        }else{
            queue.put("over");
        }
    }
}
