package com.kco.pattern.composite.demo;

/**
 * 游戏角色
 * Created by Administrator on 2017/5/16.
 */
public abstract class GameRole {
    protected String name;

    public GameRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
