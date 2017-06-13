package com.kco.pattern.strategy.demo1;

import org.apache.poi.ss.formula.functions.T;

/**
 * Created by Administrator on 2017/6/13.
 */
public class OnDriveCarMode implements TransportationMode {
    @Override
    public void run() {
        System.out.println("通过开车....");
    }
}
