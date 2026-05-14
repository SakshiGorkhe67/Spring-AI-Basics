package com.openai.chatmodel001.controller;

import com.openai.chatmodel001.services.ChatClientService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    ChatClientService chatClientService;

    @GetMapping("/ask")
    public String ask() {
        chatClientService.askQuestion();
        return "Check console for responses from both OpenAI and Anthropic models.";
    }
}
