package com.kco.pattern.template.demo1;

import java.util.Random;

/**
 * Created by Administrator on 2017/6/13.
 */
public class KnightsOfValour extends Game{
    private static String[] levelName = {
            "截江救阿斗",
            "定军斩夏侯",
            "威震汉中池",
            "大意失荆州",
            "智破八阵图",
            "雪战夺荆州",
            "三国归一统"
    };
    private static Random random = new Random();

    @Override
    protected void chooseRole() {
        System.out.println("选择诸葛亮...");
    }

    @Override
    protected void initGame() {
        System.out.println("载入三国战机.....");
    }

    @Override
    protected String[] getLevelName() {
        return levelName;
    }
}
