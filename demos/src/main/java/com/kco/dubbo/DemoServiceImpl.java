package com.kco.dubbo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        User u1 = new User();
        u1.setName("Jack");
        u1.setAge(20);

        User u2 = new User();
        u2.setName("tom");
        u2.setAge(21);

        User u3 = new User();
        u3.setName("rose");
        u3.setAge(19);

        list.add(u1);
        list.add(u2);
        list.add(u3);
        return list;
    }
}
