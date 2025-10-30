package com.mongoDb.chatProject.controller;

import com.mongoDb.chatProject.domain.ChattingContent;
import com.mongoDb.chatProject.repository.ChatRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatRepository chatRepository;

    @GetMapping("/save")
    public ChattingContent test(@RequestParam String name, @RequestParam Long age) {
        ChattingContent content = new ChattingContent(name, age);
        return chatRepository.save(content);
    }

    @GetMapping("/find")
    public ChattingContent find(@RequestParam String name) {
        return chatRepository.findChattingContentByName(name);
    }

}
