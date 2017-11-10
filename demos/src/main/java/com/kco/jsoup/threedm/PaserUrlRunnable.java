package com.kco.jsoup.threedm;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
        Element nextAchor = parse.select(".pagelistbox a:nth-last-child(2)").last();

        Element connext = parse.select(".con").last();
        connext.select(".page_fenye,script,.miaoshu").remove();
        connext.select("p").first().remove();
        connext.select("p").last().remove();
        connext.select("p").last().remove();
        connext.select("img").stream().forEach(img -> {
            String src = img.attr("src");
            try {
                queue.put(src);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            img.attr("src", src.replaceAll("http://", ""));
            img.attr("style", "max-width:100%;");
        });

        FileUtils.write(new File(baseFilePath + this.baseUrl.getName() +".html"), connext.toString(), true);
        if (nextAchor != null && nextAchor.text().equals("下页")){
            paserUrl(nextAchor.attr("abs:href"));
        }else{
            queue.put("over");
        }
    }
}
