package com.api.openai.controller;

import com.api.openai.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/chat/{promt}")
    public String chat(@PathVariable String promt){
        return chatService.getChatResponse(promt);
    }
}
