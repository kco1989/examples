package com.kco.dubbo.demo1.client;

import com.kco.dubbo.demo1.api.DemoService;
import com.kco.dubbo.demo1.api.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */
public class ClientApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/dubbo/demo1/consumer.xml");
        context.start();

        DemoService demoService = context.getBean("demoService", DemoService.class);
        String ricky = demoService.sayHello("ricky");
        System.out.println("================");
        System.out.println(ricky);
        List<User> users = demoService.getUsers();
        System.out.println("================");
        System.out.println(users);
    }
}
