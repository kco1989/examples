package com.kco.pattern.factory.demo2;

/**
 * Created by Administrator on 2017/5/10.
 */
public class MazdaCar implements Car {
    @Override
    public void run() {
        System.out.println("我是马自达,我在路上飞奔..");
    }
}
