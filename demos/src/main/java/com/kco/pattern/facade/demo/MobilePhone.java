package com.kco.pattern.facade.demo;

/**
 * Created by Administrator on 2017/5/12.
 */
public class MobilePhone {

    private AirCleaner airCleaner = new AirCleaner();
    private AirConditioning airConditioning = new AirConditioning();
    private Light light = new Light();
    private Television television = new Television();

    public void goHome(){
        airCleaner.on();
        airConditioning.on();
        light.on();
        television.on();
    }

    public void leaveHome(){
        airCleaner.off();
        airConditioning.off();
        light.off();
        television.off();
    }
}
