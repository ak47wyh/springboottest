package com.example.demo.t3;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/2.
 */
@Service
public class ScheduleTaskService {
    private static final SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每隔5秒执行一次 "+dateformat.format(new Date()));
    }
    @Scheduled(cron = "0/15 * * * * *")
    public void fixTimeExecution(){
        System.out.println("每隔15秒执行一次 "+dateformat.format(new Date()));
    }
}
