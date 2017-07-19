package com.kco.dubbo.demo1.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 2017/7/18.
 */
public class ServerApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/dubbo/demo1/provider.xml");
        context.start();
        System.out.println("Dubbo provider start....");

        try {
            System.in.read();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
