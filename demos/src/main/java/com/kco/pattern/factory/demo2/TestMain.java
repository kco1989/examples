package com.kco.pattern.factory.demo2;

/**
 * Created by Administrator on 2017/5/10.
 */
public class TestMain {
    public static void main(String[] args) {
        CarFactory bwmFactory = new BmwCarFactory();
        CarFactory bydFactory = new BydCarFactory();
        CarFactory mazdaFactory = new MazdaCarFactory();
        Car bwn = bwmFactory.createCar();
        Car byd = bydFactory.createCar();
        Car mazda = mazdaFactory.createCar();
        bwn.run();
        byd.run();
        mazda.run();
    }
}
