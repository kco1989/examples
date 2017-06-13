package com.kco.pattern.strategy.demo1;

/**
 * Created by Administrator on 2017/6/13.
 */
public class TestMain {
    public static void main(String[] args) {
        GoHome goHome = new GoHome();

        goHome.goHome();
        System.out.println("=================");

        goHome.setMode(new OnFootMode());
        goHome.goHome();
        System.out.println("=================");

        goHome.setMode(new TaxiMode());
        goHome.goHome();
        System.out.println("=================");

        goHome.setMode(new OnDriveBicycleMode());
        goHome.goHome();
        System.out.println("=================");

        goHome.setMode(new OnDriveCarMode());
        goHome.goHome();
        System.out.println("=================");
    }
}
