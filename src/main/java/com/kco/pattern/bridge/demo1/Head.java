package com.kco.pattern.bridge.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public class Head {
    private Hair hair;
    private Face face;

    public Head(Hair hair, Face face) {
        this.hair = hair;
        this.face = face;
    }

    @Override
    public String toString() {
        return "角色拥有: " + hair + " 和 " + face;
    }
}
