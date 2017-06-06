package com.example.demo.web;

import com.example.demo.service.WsResponse;
import com.example.demo.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

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

    @Autowired
    private SimpMessagingTemplate msgTemplate;

//    chat
    @MessageMapping("/chat")
    public void handleChat(Principal principal,String msg){
        if(principal.getName().equals("admin")){
            msgTemplate.convertAndSendToUser("wyh","queue/notifications",principal.getName()+"-send:"+msg);
        }else {
            msgTemplate.convertAndSendToUser("admin","queue/notifications",principal.getName()+"--send:"+msg);
        }
    }
}
