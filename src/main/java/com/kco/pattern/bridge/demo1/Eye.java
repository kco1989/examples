package com.kco.pattern.bridge.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public abstract class Eye {
    protected Color color;
    public abstract String name();

    public Eye(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return name() + ",拥有 " + color + "的眼珠" ;
    }
}
