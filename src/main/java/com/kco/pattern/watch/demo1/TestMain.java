package com.kco.pattern.watch.demo1;

/**
 * Created by Administrator on 2017/6/13.
 */
public class TestMain {
    public static void main(String[] args) {
        Celebrity xingYe = new Celebrity("周星驰");
        Celebrity huaZai = new Celebrity("刘德华");

        for (int i = 0; i < 3; i ++){
            Follower fun = new Follower("粉丝" + i);
            xingYe.add(fun);
        }

        for (int i = 3; i < 6; i ++){
            Follower fun = new Follower("粉丝" + i);
            xingYe.add(fun);
            huaZai.add(fun);
        }

        for (int i = 6; i < 9; i ++){
            Follower fun = new Follower("粉丝" + i);
            huaZai.add(fun);
        }

        xingYe.notifyWatcher("出新的电影了");
        huaZai.notifyWatcher("在深圳开演唱会了.");
    }
}
