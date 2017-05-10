package com.kco.pattern.factory.demo1;

/**
 * Created by Administrator on 2017/5/10.
 */
public class TestMain {
    public static void main(String[] args) {
        Car bmw = CarFactory.createCar("BMW");
        Car byd = CarFactory.createCar("BYD");
        Car mazDa = CarFactory.createCar("MazDa");
        bmw.run();
        byd.run();
        mazDa.run();
    }
}
