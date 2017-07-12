package com.kco.pattern.factory.demo3;

/**
 * Created by Administrator on 2017/5/10.
 */
public class BmwEngine implements Engine{
    @Override
    public void description() {
        System.out.println("制造宝马的引擎");
    }
}
