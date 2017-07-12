package com.kco.pattern.proxy.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public class WangPo implements Woman {
    private Woman woman;
    public WangPo(Woman woman) {
        this.woman = woman;
    }

    @Override
    public void heiheihei() {
        System.out.println("王婆找来 " + woman);
        woman.heiheihei();
        System.out.println("王婆送走 " + woman);
    }
}
