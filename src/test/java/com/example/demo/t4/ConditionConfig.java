package com.example.demo.t4;

import org.springframework.context.annotation.*;

/**
 * Created by Administrator on 2017/6/2.
 */
@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(WinCondition.class)
    public ListService winListService(){
        return new WinListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService LinuxListService(){
        return new LinuxListService();
    }

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService service = context.getBean(ListService.class);

        System.out.println(context.getEnvironment().getProperty("os.name")+" 系统命令："+service.showListCmd());
    }
}
