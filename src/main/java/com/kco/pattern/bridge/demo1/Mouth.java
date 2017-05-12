package com.kco.pattern.bridge.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public abstract class Mouth {
    public  abstract String name();
    @Override
    public String toString() {
        return name();
    }
}
