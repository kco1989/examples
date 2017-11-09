package com.kco.jsoup.demo4;

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
    private String baseUrl;
    private BlockingQueue<String> queue;

    public PaserUrlRunnable(String baseFilePath, String baseUrl, BlockingQueue<String> queue) {
        this.baseFilePath = baseFilePath;
        this.baseUrl = baseUrl;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            FileUtils.write(new File(baseFilePath + "index.html"), "<!doctype html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\"\n" +
                    "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                    "    <title>Document</title>\n" +
                    "</head>\n" +
                    "<body>", true);
            paserUrl(baseUrl);
            FileUtils.write(new File(baseFilePath + "index.html"), "\n" +
                    "</body>\n" +
                    "</html>", true);
        }catch (Exception e){

        }

    }

    private void paserUrl(String url) throws Exception {
        System.out.println("===> " + url);
        Document parse = Jsoup.connect(url).execute().parse();
        Element element = parse.select("div.page_css a").last();
        Element connext = Jsoup.connect(baseUrl).get().select(".Mid2L_con").last();
        connext.select("#pe100_page_contentpage").remove();
        connext.select("#pe100_page_contentpage").remove();
        connext.select(".referencecontent").remove();
        connext.select(".gs_ccs_solve").remove();
        connext.select("p[align='center'] a").stream().forEach(item -> item.replaceWith(
                item.select("img").first()
        ));
        connext.select("p[align='center'] img").stream().forEach(item ->{
            String dataSrc = item.attr("data-src");
//            queue.add(dataSrc);
            item.attr("src", dataSrc.replaceAll("http://", ""));
        });
        connext.select(".blockreference").remove();
        FileUtils.write(new File(baseFilePath + "index.html"), connext.toString(), true);
        if (element != null && element.text().equals("下一页")){
            paserUrl(element.attr("href"));
        }else{
            queue.put("over");
        }
    }
}
