package com.kco.pattern.singleton;

/**
 * Created by Administrator on 2017/5/11.
 */
public class Singleton3 {
    private Singleton3(){}
    private static Singleton3 singleton2 = new Singleton3();
    public static Singleton3 getInstance(){
        return singleton2;
    }
}
