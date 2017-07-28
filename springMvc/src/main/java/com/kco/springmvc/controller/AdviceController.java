package com.kco.springmvc.controller;

import com.kco.springmvc.bean.DemoBean;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2017/7/28.
 */
@Controller
public class AdviceController {
    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoBean bean) {
        throw new IllegalArgumentException("非常抱歉, 参数有误来自@ModelAttribute:" + msg);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String upload(MultipartFile file1, MultipartFile file2){
        try{
            FileUtils.writeByteArrayToFile(new File("e:/" + file1.getOriginalFilename()),
                    file1.getBytes());
            FileUtils.writeByteArrayToFile(new File("e:/" + file2.getOriginalFilename()),
                    file2.getBytes());
            return "ok";
        }catch (Exception e){
            e.printStackTrace();
            return "wrong";
        }
    }

    @RequestMapping(value = "/uploads", method = RequestMethod.POST)
    public @ResponseBody String upload(@RequestParam("file") CommonsMultipartFile files[]){
        try{
            for (CommonsMultipartFile file : files){
                if (file == null){
                    continue;
                }
                FileUtils.writeByteArrayToFile(new File("e:/" + UUID.randomUUID()),
                        file.getBytes());
            }
            return "ok";
        }catch (Exception e){
            e.printStackTrace();
            return "wrong";
        }
    }

}
