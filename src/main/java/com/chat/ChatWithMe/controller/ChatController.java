package com.chat.ChatWithMe.controller;

import com.chat.ChatWithMe.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    //maps web socket messages to its destination. When someone sends a message to /sendmessage endpoint it will send that
    // message to whichever endpoint you write in the @sendto annotation
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages") //recieves messages from /topic/messages
    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }

    @GetMapping("chat")
    public String chat(){
        return "chat";
    }
}
