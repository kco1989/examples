package com.kco.jsoup.youming;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * Created by 666666 on 2017/11/9.
 */
public class PaserUrlRunnable implements Runnable{
    private String baseFilePath;
    private UrlBean baseUrl;
    private BlockingQueue<String> queue;

    public PaserUrlRunnable(String baseFilePath, UrlBean baseUrl, BlockingQueue<String> queue) {
        this.baseFilePath = baseFilePath;
        this.baseUrl = baseUrl;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            FileUtils.write(new File(baseFilePath +  baseUrl.getName() +".html"), "<!doctype html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\"\n" +
                    "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                    "    <title>Document</title>\n" +
                    "</head>\n" +
                    "<body>", true);
            paserUrl(baseUrl.getUrl());
            FileUtils.write(new File(baseFilePath + baseUrl.getName() +".html"), "\n" +
                    "</body>\n" +
                    "</html>", true);
        }catch (Exception e){

        }

    }

    private void paserUrl(String url) throws Exception {
        System.out.println("===> " + url);
        Document parse = Jsoup.connect(url).execute().parse();
        Element element = parse.select("div.page_css a").last();
        Element connext = parse.select(".Mid2L_con").last();
        connext.select("#pe100_page_contentpage").remove();
        connext.select("#pe100_page_contentpage").remove();
        connext.select(".referencecontent").remove();
        connext.select(".gs_ccs_solve").remove();
        connext.select("p[align='center'] a").stream().forEach(item -> item.replaceWith(
                item.select("img").first()
        ));
        connext.select("p[align='center'] img").stream().forEach(item ->{
            String dataSrc = item.attr("data-src");
            try {
                queue.put(dataSrc);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            item.attr("src", dataSrc.replaceAll("http://", ""));
            item.attr("style", "max-width:100%;");
        });
        connext.select(".blockreference").remove();
        FileUtils.write(new File(baseFilePath + this.baseUrl.getName() +".html"), connext.toString(), true);
        if (element != null && element.text().equals("下一页")){
            paserUrl(element.attr("href"));
        }else{
            queue.put("over");
        }
    }
}
