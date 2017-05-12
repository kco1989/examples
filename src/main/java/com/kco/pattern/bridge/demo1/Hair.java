package com.kco.pattern.bridge.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public abstract class Hair {
    protected Color color;
    public abstract String name();

    public Hair(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color + "的" + name();
    }
}
