package com.kco.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * Created by Administrator on 2017/7/28.
 */
@Controller
public class SseController {
    @RequestMapping(value = "/push", produces = "text/event-stream; charset=UTF-8")
    public @ResponseBody String push(){
        Random r = new Random();
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "data:Testint 1, 2, 3 " + r.nextInt() + "\n\n";
    }
}
