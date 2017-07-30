package com.kco.controller;

import com.kco.bean.AuthorSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by pc on 2017/7/30.
 */
@RestController
public class IndexController {

    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;

    @Resource
    private AuthorSettings authorSettings;
    @RequestMapping("/")
    public String index(){
        return "book name is:" + bookName + ",and book author is:" + bookAuthor;
    }

    @RequestMapping("/helloboot")
    public String helloboot(){
        return "Hello  Boot";
    }

    @RequestMapping("/getAuthorSetting")
    public AuthorSettings getAuthorSetting(){
        return authorSettings;
    }
}
