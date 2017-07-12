package com.kco.pattern.proxy.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public class PanjinLian implements Woman {
    @Override
    public void heiheihei() {
        System.out.println("潘金莲在嘿嘿嘿....");
    }

    @Override
    public String toString() {
        return "潘金莲";
    }
}

