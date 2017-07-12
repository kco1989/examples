package com.kco.pattern.build;

/**
 * Created by Administrator on 2017/5/11.
 */
public class TestMain {

    public static void main(String[] args) {
        ComputerBuild b = new ComputerBuild();
        Computer computerA = b.operatingSystem("window 系统")
                .graphicsCard("发烧友显卡")
                .memory("16G 内存")
                .cpu("奔腾I7")
                .type("游戏本")
                .build();
        Computer computerB = b.operatingSystem("linux 系统")
                .graphicsCard("入门级显卡")
                .memory("8G 内存")
                .cpu("奔腾I5")
                .type("上网本")
                .build();
        System.out.println(computerA);
        System.out.println(computerB);
    }
}
