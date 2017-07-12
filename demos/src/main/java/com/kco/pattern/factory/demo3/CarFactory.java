package com.kco.pattern.factory.demo3;

/**
 * Created by Administrator on 2017/5/10.
 */
public interface CarFactory {

    Wheel createWheel();

    Engine createEngine();

    Surface createSurface();
}
