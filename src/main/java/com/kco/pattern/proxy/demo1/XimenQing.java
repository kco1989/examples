package com.kco.pattern.proxy.demo1;

/**
 * Created by Administrator on 2017/5/12.
 */
public class XimenQing {
    public static void main(String[] args) {
        WangPo wangPo = new WangPo(new PanjinLian());
        wangPo.heiheihei();
    }
}
