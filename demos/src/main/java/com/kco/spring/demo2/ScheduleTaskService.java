package com.kco.spring.demo2;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/28.
 */
@Service
public class ScheduleTaskService {

    private static final SimpleDateFormat dateFormate = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每5妙执行一次: " + dateFormate.format(new Date()));
    }

    @Scheduled(cron = "0 56 10 ? * *")
    public void fixTimeExecution(){
        System.out.println("在指定时间: " + dateFormate.format(new Date()));
    }
}
