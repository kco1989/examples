package com.kco.pattern.strategy.demo1;

/**
 * Created by Administrator on 2017/6/13.
 */
public class OnDriveBicycleMode implements TransportationMode {
    @Override
    public void run() {
        System.out.println("通过骑单车......");
    }
}
