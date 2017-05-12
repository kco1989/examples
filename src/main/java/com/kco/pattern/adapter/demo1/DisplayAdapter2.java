package com.kco.pattern.adapter.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public class DisplayAdapter2 extends DisplayDevice implements Notebook{
    @Override
    public void usb() {
        serialPort();
    }
}
