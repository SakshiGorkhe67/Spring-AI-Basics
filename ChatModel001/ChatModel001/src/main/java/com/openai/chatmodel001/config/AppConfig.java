package com.openai.chatmodel001.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    ChatClient chatClient (ChatClient.Builder builder){
        return builder
                .defaultSystem("You are a coding assistant")
                .build();

    }
}
