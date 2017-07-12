package com.kco.pattern.factory.demo3;

/**
 * Created by Administrator on 2017/5/10.
 */
public class BydWheel implements Wheel {
    @Override
    public void description() {
        System.out.println("制造比亚迪的轮子");
    }
}
