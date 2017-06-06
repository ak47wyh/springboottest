package com.example.demo.t3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Administrator on 2017/6/2.
 */
@Configuration
@ComponentScan("com.example.demo.t3")
@EnableScheduling
public class ScheduleConfig {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduleConfig.class);

    }

}
