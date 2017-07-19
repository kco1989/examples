package com.kco.dubbo.demo2.server;

import com.alibaba.dubbo.config.annotation.Service;
import com.kco.dubbo.demo2.api.Demo2Service;

/**
 * Created by Administrator on 2017/7/19.
 */
@Service(version = "1.0.0")
public class Demo2ServiceImpl implements Demo2Service {
    @Override
    public String sayHi(String name) {
        return "Hi, " + name;
    }
}
