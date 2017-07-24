package com.kco.rmi.demo2;

import java.io.IOException;

/**
 * Created by Administrator on 2017/7/24.
 */
public class Client {
    public static void main(String[] args) throws Throwable {
        Person person = new PersonStub();
        int age = person.getAge();
        System.out.println("age : " + age);
        String name = person.getName();
        System.out.println("name: " + name);
    }
}
