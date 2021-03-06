package com.kco.jsoup.demo1;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

/**
 * Created by 666666 on 2017/8/24.
 */
public class Demo2 {
    public static void main(String[] args) {
        String[] baseUrl = {
//                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LQxBt8aSbvOi-27BV0qKdqey6ylq",
//                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LQxBt8aSbvOi-27BV0tKRqey6ylq",
//                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7XZpPPwHOReMYYwk_d07UozBAxr_xotn9hbSS8w_m58By0GhEDtsUt2q",
//                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LQxBt8aSbvOi-27BF1q_dqey6ylq",
//                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7XZpPPwHOReMYYwk_d07UpzBAxrKtmsX9hbSS8w_m58By2GhIDtsUt2q",
//                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=%E5%92%8C%E8%80%81%E5%A9%86%E5%88%BA%E6%BF%80%E7%9A%84%E6%80%A7%E7%88%B1%E8%AE%B0%E5%BD%95_%E6%89%8B%E6%9C%BA%E5%B0%8F%E8%AF%B4%2C%E5%B0%8F%E8%AF%B4%E5%9C%A8%E7%BA%BF%E9%98%85%E8%AF%BB%2Ctxt%E5%B0%8F%E8%AF%B4...&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LQxBt8aSbvOi-27BFBqq-qey6ylq",
//                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp73GkT7t7aLfgoDli8-OzFehhB0t_lovTFbliG",
//                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LQxBt8aSbvOi-29BVCrLIwdzZz",
//                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LQxBt8aSbvOi-27xF0qaNqey6ylq",
//                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LQxBt8aSbvOi-27BVBt_lqey6ylq",
//                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LQxBt8wXyc275skNYWgK",
//                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LQxBt8aSbvOi-28BJ3rbIwdzZz",
//                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LQxBt8aSbvOi-27Bp1tKNqey6ylq"
                // 茅山术之捉鬼人
                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LPxBt8aSbvOi-27xF_rK6qey6ylq",
                // 民间淫骨菩萨的传闻
                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LPxBt8aSbvOi-27BF2qqRqey6ylq",
                // 触摸恐怖最低限——窥阴
                "http://www.shoujikanshu.org/Direct1/index_747.html",
                // 隔壁漂亮姐姐让我用那种方法，帮她治不孕
                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LPxBt8aSbvOi-27B2ArK-qey6ylq",
                // 鬼姬
                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LPxBt8aSbvOi-27xZ2qadqey6ylq",
                // 浴缸
                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7yGlPwx8LPxBt8aSbvOi-27xZ2tKxqey6ylq",
                // 尸语者(法医秦明系列1)
                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7pFlLdwWyRhAoDli8-OzFehhB1tKxnvTFbliG",
                // 无声的证词(法医秦明系列2)
                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7pFlLdwWyRhAoDli8-OzFehhB1tKxmvTFbliG",
                // 第十一根手指(法医秦明系列3)
                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7pFlLdwWyRhAoDli8-OzFehhB2rqtkvTFbliG",
                // 清道夫(法医秦明系列4)
                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7pFlLdwWyRhAoDli8-OzFehhB1tKxpvTFbliG",
                // 幸存者(法医秦明·第5季)
                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7pFlLdwWyRhAoDli8-OzFehhB1tKxovTFbliG",
                // 偷窥者(法医秦明第六季)
                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7pFlLdwWyRhAoDli8-OzFehhB1qaNhvTFbliG",
                // 原来的世界
                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7pFlLdwWyRhAoDli8-OzFehhB2tKhhvTFbliG",
                // 我的女友是冥王
                "http://transcoder.baiducontent.com/tc?srd=1&dict=32&h5ad=1&bdenc=1&lid=8874999729740906145&title=&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztQ0Su9pEK7hO4nFRhpUDSqAp7pFlLdwWyRhAoDli8-OzFehhB1ra-jvTFbliG",
        };
        for (String url : Const.BOOK_URL){
            parseXSIndexUrl(url);
        }

    }

    private static void parseXSIndexUrl(String url) {
        try {
            Document parse = Jsoup.connect(url).execute().parse();
            String title = parse.select("div.box-artic>h1").html().trim();
            Elements alist = parse.select("div.list>li>a");
            File tmpFile = new File("tmp");
            BufferedWriter bw = new BufferedWriter(new FileWriter(tmpFile));
            for (Element e : alist){
                String content = getContent(e.attr("href"));
                bw.write(content);
                bw.flush();
            }
            bw.close();
            dropBlankLine(tmpFile, title + ".txt");
            System.out.println("解析完:" + title);
        }catch (Exception e){
            System.err.println("解析url出错:" + url);
        }
    }

    private static void dropBlankLine(File tmpFile, String outFileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(tmpFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outFileName));
        String line = "";
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
        return select.html().replaceAll("<br>", "\n");
    }
}
