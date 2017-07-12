package com.kco.pattern.factory.demo3;

/**
 * Created by Administrator on 2017/5/10.
 */
public class BmwWheel implements Wheel {
    @Override
    public void description() {
        System.out.println("制造宝马的轮子");
    }
}
