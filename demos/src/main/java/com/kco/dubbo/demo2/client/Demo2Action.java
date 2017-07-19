package com.kco.dubbo.demo2.client;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kco.dubbo.demo2.api.Demo2Service;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/7/19.
 */
@Component
public class Demo2Action {

    @Reference(version = "1.0.0")
    private Demo2Service demo2Service;

    public void sayHi(){
        System.out.println("===========start===============");

        String jack = demo2Service.sayHi("Jack");
        System.out.println(jack);
        System.out.println("===========end===============");
    }
}
