package com.kco.dubbo.demo2.client;

import com.kco.dubbo.demo1.api.DemoService;
import com.kco.dubbo.demo1.api.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */
public class ClientApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/dubbo/demo2/consumer.xml");
        context.start();

        Demo2Action demo2Action = context.getBean("demo2Action", Demo2Action.class);
        demo2Action.sayHi();
    }
}
