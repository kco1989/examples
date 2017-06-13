package com.kco.pattern.strategy.demo1;

/**
 * Created by Administrator on 2017/6/13.
 */
public class GoHome {
    private TransportationMode mode;
    private static TransportationMode defaultMode = new BusMode();
    public TransportationMode getMode() {
        return mode;
    }

    public void setMode(TransportationMode mode) {
        this.mode = mode;
    }

    public void goHome(){
        System.out.println("从公司出发...");
        if (mode == null){
            mode = defaultMode;
        }
        mode.run();
        System.out.println("回到家了....");
    }
}
