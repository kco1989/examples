package com.kco.jsoup.demo1;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 666666 on 2017/8/24.
 */
public class Demo1 {

    public static void main(String[] args) throws Exception {

        String baseUrl = "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LQxBt8aSbvOi-27BV0qKdqey6ylq";
        File file = new File("1.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        Connection connect = Jsoup.connect(baseUrl);
        Connection.Response execute = connect.execute();

        Document parse = execute.parse();
        Elements select = parse.select("div.list>li>a");

        System.out.println(select.attr("href"));
        for (Element e : select){
            String content = getContent(select.attr("href")).replaceAll("<br>", "\n").replaceAll("^\\s*$", "");
            bw.write(content);
            bw.flush();
        }
        bw.close();
        dropBlankLine(file);
    }

    private static void dropBlankLine(File file) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMDDHHmmss");
        String outFileName = simpleDateFormat.format(new Date()) + ".txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(outFileName));
        while ((line = br.readLine()) != null){
            if (StringUtils.isNotBlank(line)){
                bw.write(line.trim() + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static String getContent(String href) throws IOException {
        Connection connect = Jsoup.connect(href);
        Connection.Response execute = connect.execute();
        Elements select = execute.parse().select("div.content");
        return select.html();
    }
}
