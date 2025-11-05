package com.mongoDb.chatProject.controller;

import com.mongoDb.chatProject.domain.ChattingContent;
import com.mongoDb.chatProject.domain.ChattingRoom;
import com.mongoDb.chatProject.dto.chat.request.CreateRoom;
import com.mongoDb.chatProject.dto.chat.request.SendMessage;
import com.mongoDb.chatProject.dto.chat.response.SendMessageResponse;
import com.mongoDb.chatProject.repository.ChattingContentRepository;
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
    private final ChattingContentRepository chattingContentRepository;

    @PostMapping("/create/room")
    public void createChatRoom(@RequestBody CreateRoom createRoom) {
        chatService.createChatRoom(createRoom);
    }

    @PostMapping("/message/send")
    public SendMessageResponse sendMessage(@RequestBody SendMessage sendMessage) {
        return chatService.sendMessage(sendMessage);
    }


    /**
     * =======================================
     * 아래는 데이터 확인용
     */
    @GetMapping("/find/all/room")
    public List<ChattingRoom> getAllChattingRooms() {
        return chattingRoomRepository.findAll();
    }
    @GetMapping("/find/all/message")
    public List<ChattingContent> getAllChattingMessages(@RequestParam String roomId) {
        return chattingContentRepository.findByRoomId(roomId);
    }
}
