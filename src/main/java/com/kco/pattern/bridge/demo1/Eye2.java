package com.kco.pattern.bridge.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public class Eye2 extends Eye {

    @Override
    public String name() {
        return "丹凤眼";
    }

    public Eye2(Color color) {
        super(color);
    }
}
