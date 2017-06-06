package com.example.demo.t2;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/6/2.
 */
@Service
public class AsynTaskService {
    @Async
    public void excuteAsyncTask(Integer i){
        System.out.println("执行异步任务："+i);
    }

    public void excuteAsyncTaskPlus(Integer i){
        System.out.println("执行任务执行器+1："+(i+1));
    }
}
