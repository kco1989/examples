package com.kco.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/7/25.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index(){
        return "hello wolrd!";
    }
}
