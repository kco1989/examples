package com.kco.pattern.decorator.demo;

/**
 * Created by Administrator on 2017/5/12.
 */
public class HandCakeFood implements Food {

    @Override
    public String description() {
        return "手抓饼";
    }

    @Override
    public double price() {
        return 5.0;
    }
}
