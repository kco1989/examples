package com.kco.pattern.bridge.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public enum Color {
    Red("红色"),Yello("黄色"),Blue("蓝色"),White("白色"),Black("黑色");
    private String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
