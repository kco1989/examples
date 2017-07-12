package com.kco.pattern.singleton;

/**
 * Created by Administrator on 2017/5/11.
 */
public class Singleton1 {
    private Singleton1(){}
    private static Singleton1 singleton1;
    public static synchronized Singleton1 getInstance(){
        if (singleton1 == null){
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}
