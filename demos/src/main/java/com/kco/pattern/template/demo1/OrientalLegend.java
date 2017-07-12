package com.kco.pattern.template.demo1;

/**
 * Created by Administrator on 2017/6/13.
 */
public class OrientalLegend extends Game {
    private static String[] levelName = {
            "平顶山——莲花洞",
            "枯松涧——火云洞",
            "车迟国——智渊寺",
            "通天河——水鱼之家",
            "盘丝岭——盘丝洞",
            "狮驼岭——狮驼洞",
            "火焰山——芭蕉洞"
    };
    @Override
    protected void chooseRole() {
        System.out.println("选择孙悟空...");
    }

    @Override
    protected void initGame() {
        System.out.println("载入西游释厄传....");
    }

    @Override
    protected String[] getLevelName() {
        return levelName;
    }
}
