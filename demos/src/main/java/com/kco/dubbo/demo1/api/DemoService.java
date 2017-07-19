package com.kco.dubbo.demo1.api;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */
public interface DemoService {
    String sayHello(String name);
    List<User> getUsers();
}
