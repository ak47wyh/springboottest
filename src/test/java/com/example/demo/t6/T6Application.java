package com.example.demo.t6;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/6/2.
 */
@RestController
@SpringBootApplication
public class T6Application {

    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;

    @RequestMapping("/")
    public String index(){
        return "book name is :"+bookName+" and book author is :"+bookAuthor;
    }

    public static void main(String[] args){
        SpringApplication.run(T6Application.class,args);
    }

    /**
     * 内部配置类
     */
//    @Component
    public static class CustomServiceContainer implements EmbeddedServletContainerCustomizer
    {
        @Override
        public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
            configurableEmbeddedServletContainer.setPort(8082);
            configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
            configurableEmbeddedServletContainer.setSessionTimeout(10, TimeUnit.MINUTES);
        }
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainerFactory(){
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8083);
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
        return factory;
    }
}
