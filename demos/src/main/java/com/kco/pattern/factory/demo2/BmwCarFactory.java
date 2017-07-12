package com.kco.pattern.factory.demo2;

/**
 * Created by Administrator on 2017/5/10.
 */
public class BmwCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new BmwCar();
    }
}
