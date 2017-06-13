package com.kco.pattern.watch.demo1;

/**
 * Created by Administrator on 2017/6/13.
 */
public class Follower implements Watcher{
    private String name;

    public Follower(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " 观察到 " + message);
    }
}
