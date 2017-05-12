package com.kco.pattern.bridge.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public abstract class Face {
    protected Color color;
    protected Eye eye;
    protected Nose nose;
    protected Mouth mouth;
    protected Ear ear;
    public abstract String name();

    public Face(Color color, Eye eye, Nose nose, Mouth mouth, Ear ear) {
        this.color = color;
        this.eye = eye;
        this.nose = nose;
        this.mouth = mouth;
        this.ear = ear;
    }

    @Override
    public String toString() {
        return color + "的" + name() + ", 眼睛: " + eye + ", 鼻子: " + nose + ", 嘴巴:" + mouth + ",耳朵: " + ear;
    }
}
