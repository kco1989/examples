package com.kco.pattern.adapter.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public class DisplayAdapter1 implements Notebook{
    private DisplayDevice displayDevice;

    public DisplayAdapter1(DisplayDevice displayDevice) {
        this.displayDevice = displayDevice;
    }
    @Override
    public void usb() {
        displayDevice.serialPort();
    }
}
