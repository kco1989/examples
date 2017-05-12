package com.kco.pattern.bridge.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public class Hair1 extends Hair{
    @Override
    public String name() {
        return "卷发";
    }

    public Hair1(Color color) {
        super(color);
    }
}
