package com.kco.spring.demo4;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/28.
 */
@Service
public class DemoService {
    public void outputResult(){
        System.out.println("从组合注解撇子照样获取的Bean");
    }
}
