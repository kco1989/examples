package com.kco.jsoup.demo2;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 666666 on 2017/11/3.
 */
public class JsonTest {
    private static Map<Integer, String> cssMap = new HashMap<Integer, String>();
    private static List<CityCode> list = new ArrayList<>();
    private static int count = 0;
    static
    {
        cssMap.put(1, "provincetr");// 省
        cssMap.put(2, "citytr");// 市
        cssMap.put(3, "countytr");// 县
        cssMap.put(4, "towntr");// 镇
        cssMap.put(5, "villagetr");// 村
    }

    public static void main(String[] args) throws IOException {
        int level = 1;
        // 获取全国各个省级信息
        Document connect = connect("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2016/");
        Elements rowProvince = connect.select("tr." + cssMap.get(level));
        for (Element provinceElement : rowProvince){// 遍历每一行的省份城市
            Elements select = provinceElement.select("a");
            for (Element province : select){// 每一个省份(四川省)
                String code = province.attr("href").replace(".html", "");
                CityCode city = CityCodeBuilder.newBuilder()
                        .setCode(code)
                        .setLevel(level + "")
                        .setName(province.text())
                        .setParentId("")
                        .setType(cssMap.get(level))
                        .builder();
                list.add(city);
                System.out.println(city.getName());
                parseNextLevel(province, level + 1, code);
            }
        }
        write2File(list, true);
        System.out.println("完成");
    }

    private static void parseNextLevel(Element parentElement, int level, String parentCode) throws IOException
    {
        try {
            Thread.sleep(100);//睡眠一下，否则可能出现各种错误状态码
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Document doc = connect(parentElement.attr("abs:href"));
        if (doc != null) {
            Elements newsHeadlines = doc.select("tr." + cssMap.get(level));//
            // 获取表格的一行数据
            for (Element element : newsHeadlines) {
                String code = element.select("td").first().text();
                CityCode city = CityCodeBuilder.newBuilder()
                        .setCode(code)
                        .setLevel(level + "")
                        .setName(element.select("td").last().text())
                        .setParentId(parentCode)
                        .setType(cssMap.get(level))
                        .builder();
                list.add(city);
                write2File(list, false);
                Elements select = element.select("a");// 在递归调用的时候，这里是判断是否是村一级的数据，村一级的数据没有a标签
                if (select.size() != 0) {
                    parseNextLevel(select.last(), level + 1, code);
                }
            }
        }
    }

    private static void write2File(List<CityCode> list, boolean fouce) throws IOException {
        if (!fouce && list.size() < 500){
            return;
        }
        File file = new File("d:\\全国区域.json");
        for (CityCode cityCode : list){
            FileUtils.write(file, cityCode.toString(),"utf-8", true);
        }
        list.clear();
        System.out.println("第" + (++count) + "次...........");
    }

    private static Document connect(String url)
    {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("The input url('" + url + "') is invalid!");
        }
        try {
            return Jsoup.connect(url).timeout(100 * 1000).get();
        } catch (IOException e) {
            return null;
        }
    }
}
