package com.kco.pattern.bridge.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public class Hair2 extends Hair{
    @Override
    public String name() {
        return "长发";
    }

    public Hair2(Color color) {
        super(color);
    }
}
