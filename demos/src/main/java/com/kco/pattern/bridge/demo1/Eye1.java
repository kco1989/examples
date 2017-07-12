package com.kco.pattern.bridge.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public class Eye1 extends Eye {

    @Override
    public String name() {
        return "杏眼";
    }

    public Eye1(Color color) {
        super(color);
    }

}
