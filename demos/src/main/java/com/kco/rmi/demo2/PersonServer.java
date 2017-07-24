package com.kco.rmi.demo2;

/**
 * Created by Administrator on 2017/7/24.
 */
public class PersonServer implements Person {
    @Override
    public int getAge() throws Throwable {
        return 20;
    }

    @Override
    public String getName() throws Throwable {
        return "Jack";
    }
}
