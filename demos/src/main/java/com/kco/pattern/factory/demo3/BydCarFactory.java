package com.kco.pattern.factory.demo3;

/**
 * Created by Administrator on 2017/5/10.
 */
public class BydCarFactory implements CarFactory {
    @Override
    public Wheel createWheel() {
        return new BydWheel();
    }

    @Override
    public Engine createEngine() {
        return new BydEngine();
    }

    @Override
    public Surface createSurface() {
        return new BydSurface();
    }
}
