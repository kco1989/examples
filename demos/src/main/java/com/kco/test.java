package com.kco;

/**
 * Created by Administrator on 2017/7/13.
 */
public class test {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("game over!");
        }));
        new Thread(()->System.out.println("sd2")).start();
        new Thread(()->System.out.println("sd1")).start();
    }
}
