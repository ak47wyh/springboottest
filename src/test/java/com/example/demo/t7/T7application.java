package com.example.demo.t7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/2.
 */
@SpringBootApplication
@RestController
public class T7application {

    @Autowired
    private Book book;
    @RequestMapping("/book")
    public String pbook(){
        return "book name is :"+book.getName();
    }

    public static void main(String[] args){
        SpringApplication.run(T7application.class,args);
    }
}
