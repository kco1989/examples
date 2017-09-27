package com.kco.controller;

import com.kco.bean.AuthorSettings;
import com.kco.bean.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017/7/30.
 */
@Controller
public class IndexController {

    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;

    @Resource
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    public String index(Model model){
        Person single = new Person("aa", 11);
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("xx", 11);
        Person p2 = new Person("yy", 22);
        Person p3 = new Person("zz", 33);
        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "index";
    }
    @RequestMapping("/getBoot")
    @ResponseBody
    public String index(){
        return "book name is:" + bookName + ",and book author is:" + bookAuthor;
    }

    @RequestMapping("/helloboot")
    @ResponseBody
    public String helloboot(){
        return "Hello  Boot";
    }

    @RequestMapping("/getAuthorSetting")
    @ResponseBody
    public AuthorSettings getAuthorSetting(){
        return authorSettings;
    }
}
