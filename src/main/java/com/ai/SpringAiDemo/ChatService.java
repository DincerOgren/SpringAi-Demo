package com.ai.SpringAiDemo;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
//import org.springframework.ai.openai.OpenAiChatModel;
//import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
//
//    private final ChatModel chatModel;
//    private final OpenAiChatModel openAiChatModel;
//
//    public ChatService(ChatModel chatModel, OpenAiChatModel openAiChatModel) {
//        this.chatModel = chatModel;
//        this.openAiChatModel = openAiChatModel;
//    }
//
//    public String getResponse(String prompt) {
//        return chatModel.call(prompt);
//    }
//
//    public String getResponseOptions(String prompt) {
//        ChatResponse response = chatModel.call(
//                new Prompt(
//                        prompt,
//                        OpenAiChatOptions.builder()
//                                .model("gpt-4o")
//                                .temperature(0.2)
//                                .build()
//                ));
//
//        return  response.getResult().getOutput().getText();
//    }
}
