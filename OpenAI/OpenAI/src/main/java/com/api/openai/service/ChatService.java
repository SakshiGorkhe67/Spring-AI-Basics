package com.api.openai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service // Marks this class as a Spring Service component
public class ChatService {

    // Final means value cannot be changed after initialization
    // ChatClient is used to communicate with OpenAI model
    private final ChatClient chatClient;

    // Constructor Injection
    // Spring automatically provides ChatClient.Builder object
    public ChatService(ChatClient.Builder chatClientBuilder) {

        // build() creates the actual ChatClient object
        this.chatClient = chatClientBuilder.build();
    }

    // Method to send prompt to AI and get response
    public String getChatResponse(String prompt) {

        // chatClient -> starts AI request
        // .prompt(prompt) -> sends user input to model
        // .call() -> executes API call
        // .chatResponse() -> gets complete AI response object
        // .getResult() -> extracts result section
        // .getOutput() -> gets generated output
        // .getText() -> extracts plain text response

        return chatClient
                .prompt(prompt)
                .call()
                .chatResponse()
                .getResult()
                .getOutput()
                .getText();
    }
}

/*TIP: The ChatClient.Builder is a prototype bean,so each injection gets a new  instance.
 You can safely customize it without affecting other parts of your application.*/