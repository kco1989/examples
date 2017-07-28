package com.kco.spring.demo2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Administrator on 2017/7/28.
 */
@Configuration
@ComponentScan("com.kco.spring.demo2")
@EnableScheduling
public class TashScheduleConfig {
}
