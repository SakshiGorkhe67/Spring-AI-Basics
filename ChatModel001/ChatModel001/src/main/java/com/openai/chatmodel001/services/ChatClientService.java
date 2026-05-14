package com.openai.chatmodel001.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ChatClientService {

    @Bean
    public ChatClient OpenAiChatClient(ChatModel openAiChatModel){
        ChatClient chatClient=ChatClient.create(openAiChatModel);
        System.out.println("Create ChatClient:"+chatClient);
        System.out.println("Using ChatModel:"+openAiChatModel);
        return   chatClient;

    }
}
