package com.kco.pattern.factory.demo3;

/**
 * Created by Administrator on 2017/5/10.
 */
public class TestMain {
    public static void main(String[] args) {
        CarFactory bmwCarFactory = new BmwCarFactory();
        bmwCarFactory.createEngine().description();
        bmwCarFactory.createSurface().description();
        bmwCarFactory.createWheel().description();
        System.out.println("=========================");
        CarFactory bydCarFactory = new BydCarFactory();
        bydCarFactory.createEngine().description();
        bydCarFactory.createSurface().description();
        bydCarFactory.createWheel().description();
    }
}
