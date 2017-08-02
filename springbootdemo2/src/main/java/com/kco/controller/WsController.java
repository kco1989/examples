package com.kco.controller;

import com.kco.bean.WiselyMessage;
import com.kco.bean.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.broker.SimpleBrokerMessageHandler;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * Created by Administrator on 2017/8/1.
 */
@Controller
public class WsController {

    @Resource
    private SimpMessagingTemplate messagingTemplate;
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws Exception{

        Thread.sleep(3000);
        return new WiselyResponse("Welcome, " + message.getName());
    }

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg){
        if (principal.getName().equals("wyf")) {
            messagingTemplate.convertAndSendToUser("wisely",
                    "/queue/notifications",
                    principal.getName() + "-send:" + msg);
        }else{
            messagingTemplate.convertAndSendToUser("wyf",
                    "/queue/notifications",
                    principal.getName() + "-send:" + msg);
        }
    }
}
