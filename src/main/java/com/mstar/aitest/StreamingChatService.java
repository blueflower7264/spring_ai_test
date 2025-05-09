package com.mstar.aitest;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.StreamingChatModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class StreamingChatService {

    private StreamingChatModel streamingChatModel;

    public Flux<String> streamChatResponse(String userMessage) {
        return streamingChatModel.stream(userMessage);
        // Prompt prompt = new Prompt(userMessage);
        // return streamingChatModel.stream(prompt)
        // .map(response -> response.getResults().toString());
    }
}
