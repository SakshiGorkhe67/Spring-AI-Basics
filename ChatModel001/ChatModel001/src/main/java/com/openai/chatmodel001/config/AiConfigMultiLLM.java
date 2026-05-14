package com.openai.chatmodel001.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AiConfigMultiLLM{

    @Bean
    @Primary
    public ChatClient OpenAiChatClient(@Qualifier("openAiChatModel") ChatModel openAiChatModel) {
        ChatClient chatClient = ChatClient.create(openAiChatModel);
        System.out.println("Create ChatClient:" + chatClient);
        System.out.println("Using ChatModel:" + openAiChatModel);
        return chatClient;
    }
    @Bean
    public ChatClient anthropicChatClient(@Qualifier("anthropicChatClient") ChatModel anthropicChatModel){
        ChatClient chatClient=ChatClient.create(anthropicChatModel);
        System.out.println("Create ChatClient:"+chatClient);
        System.out.println("Using ChatModel:"+anthropicChatModel);
        return   chatClient;}
}
