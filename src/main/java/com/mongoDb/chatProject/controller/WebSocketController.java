package com.mongoDb.chatProject.controller;

import com.mongoDb.chatProject.domain.ChattingRoom;
import com.mongoDb.chatProject.dto.chat.request.SendMessage;
import com.mongoDb.chatProject.dto.chat.response.SendMessageResponse;
import com.mongoDb.chatProject.repository.ChattingRoomRepository;
import com.mongoDb.chatProject.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class WebSocketController {

    private final ChattingRoomRepository chattingRoomRepository;
    private final ChatService chatService;
    private final SimpMessagingTemplate messagingTemplate;

    @GetMapping("/find/all/room")
    public String getAllChattingRooms(Model model) {
        List<ChattingRoom> chattingRooms = chattingRoomRepository.findAll();
        model.addAttribute("rooms", chattingRooms);
        return "chat/rooms";
    }

    @MessageMapping("/message.send")
    public void sendMessage(SendMessage sendMessage) {
        SendMessageResponse sendMessageResponse = chatService.sendMessage(sendMessage);
        messagingTemplate.convertAndSend(
                "/topic/room/"+sendMessage.getRoomId(),
                sendMessageResponse);
    }
}
