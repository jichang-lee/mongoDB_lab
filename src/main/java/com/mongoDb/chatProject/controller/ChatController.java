package com.mongoDb.chatProject.controller;

import com.mongoDb.chatProject.domain.ChattingRoom;
import com.mongoDb.chatProject.dto.chat.request.CreateRoom;
import com.mongoDb.chatProject.repository.ChattingRoomRepository;
import com.mongoDb.chatProject.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;
    private final ChattingRoomRepository chattingRoomRepository;

    @PostMapping("/create/room")
    public void createChatRoom(@RequestBody CreateRoom createRoom) {
        chatService.createChatRoom(createRoom);
    }

    @GetMapping("/find/all")
    public List<ChattingRoom> getAllChattingRooms() {
        return chattingRoomRepository.findAll();
    }
}
