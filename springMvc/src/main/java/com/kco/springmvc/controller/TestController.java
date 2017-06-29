package com.kco.springmvc.controller;

import com.kco.springmvc.bean.ResponseBean;
import com.kco.springmvc.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/29.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("/getTest")
    public ResponseBean getTest(String name){
        return new ResponseBean(testService.getTest(name));
    }

    @RequestMapping("/insertTest")
    public ResponseBean insertTest(String name){
        return new ResponseBean(testService.insertTest(name));
    }
}
