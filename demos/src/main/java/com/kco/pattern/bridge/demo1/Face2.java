package com.kco.pattern.bridge.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public class Face2 extends Face {
    public Face2(Color color, Eye eye, Nose nose, Mouth mouth, Ear ear) {
        super(color, eye, nose, mouth, ear);
    }

    @Override
    public String name() {
        return "哭丧脸";
    }
}
