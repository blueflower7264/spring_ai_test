package com.mstar.aitest;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/chat")
@AllArgsConstructor
public class ChatController {

    private ChatService chatService;
    private StreamingChatService streamingChatService;

    @GetMapping("ask-me")
    public String getResponse(@RequestParam(value = "sword") String userMessage) {
        return chatService.getChatResponse(userMessage);
    }

    @GetMapping("ask-by-prompt")
    public String getPromptResponse(@RequestParam(value = "sword") String prompt) {
        return chatService.getPromptResponse(prompt);
    }

    @GetMapping("ask-by-prompt/stream")
    public Flux<String> getStreamedResponse(@RequestParam(value = "sword") String userInput) {
        return streamingChatService.streamChatResponse(userInput);
    }

    @GetMapping("chat-response")
    public ResponseEntity<String> getModelResponse(@RequestParam(value = "sword") String input){
        String response=chatService.getChatResponse(input);
        return ResponseEntity.ok(response);
    }
}
