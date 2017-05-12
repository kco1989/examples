package com.kco.pattern.adapter.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public class TestMain {

    public static void main(String[] args) {
        DisplayDevice displayDevice = new DisplayDevice();
        Notebook notebook1 = new DisplayAdapter1(displayDevice);
        notebook1.usb();

        System.out.println("=======================");

        Notebook notebook2 = new DisplayAdapter2();
        notebook2.usb();
    }
}
