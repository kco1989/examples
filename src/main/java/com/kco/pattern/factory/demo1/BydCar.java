package com.kco.pattern.factory.demo1;

/**
 * Created by Administrator on 2017/5/10.
 */
public class BydCar implements Car {
    @Override
    public void run() {
        System.out.println("我是比亚迪,我在路上飞奔..");
    }
}
