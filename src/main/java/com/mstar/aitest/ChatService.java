package com.mstar.aitest;

import lombok.AllArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChatService {

    private ChatModel chatModel;

    public String getChatResponse(String userMessage) {
        return chatModel.call(userMessage);
    }

    public String getPromptResponse(String prompt) {
        ChatResponse response = chatModel.call(
                new Prompt(
                        prompt,
                        OpenAiChatOptions.builder()
                                .model("gpt-4o")
                                .maxTokens(100)
                                .temperature(0.5)
                                .build()
                ));

        return response.getResult().getOutput().getText();
    }

}
