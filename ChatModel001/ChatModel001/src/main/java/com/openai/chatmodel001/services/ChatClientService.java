package com.openai.chatmodel001.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ChatClientService {
    @Autowired
    private ChatClient chatClient;
    @Autowired
    @Qualifier("anthropicChatClient")

    private ChatClient anthropicChatClient;


    @Bean
    public ChatClient OpenAiChatClient(ChatModel openAiChatModel){
        ChatClient chatClient=ChatClient.create(openAiChatModel);
        System.out.println("Create ChatClient:"+chatClient);
        System.out.println("Using ChatModel:"+openAiChatModel);
        return   chatClient;

    }

    //Both LLm in Single method

    public void askQuestion(){

        //  Question to OpenAI Model

        String OpenAiResponse=chatClient.prompt()
                .user("Tell me two five lines about java")
                .call()
                .content();
        System.out.println("OpenAiResponse:"+OpenAiResponse);


        System.out.println("--------------------------------------------------------");

        //Question from Anthropic Model
        //Chatclient anthropicChatClient=ChatClient.create(anthropicChatModel);


        String anthropicResponse = anthropicChatClient.prompt()
                .user("Tell me five lines about Java")
                .call()
                .content();

        System.out.println("Anthropic Response: " + anthropicResponse);




    }

}
