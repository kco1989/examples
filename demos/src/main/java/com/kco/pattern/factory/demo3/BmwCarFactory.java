package com.kco.pattern.factory.demo3;

/**
 * Created by Administrator on 2017/5/10.
 */
public class BmwCarFactory implements CarFactory {
    @Override
    public Wheel createWheel() {
        return new BmwWheel();
    }

    @Override
    public Engine createEngine() {
        return new BmwEngine();
    }

    @Override
    public Surface createSurface() {
        return new BmwSurface();
    }
}
