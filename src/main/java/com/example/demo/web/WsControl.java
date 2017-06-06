package com.example.demo.web;

import com.example.demo.service.WsResponse;
import com.example.demo.vo.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/6/5.
 */
@Controller
public class WsControl {

    @MessageMapping("/wsMessage")
    @SendTo("/topic/getResponse")
    public WsResponse sendMsg(Message message) throws InterruptedException {

        Thread.sleep(3000);
        return new WsResponse("Welcome, "+message.getName()+"!");
    }

    @RequestMapping("/wsMsg")
    public String goToWs(){
        return "wsMsg";
    }
}
