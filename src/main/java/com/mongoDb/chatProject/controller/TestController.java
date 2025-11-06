package com.mongoDb.chatProject.controller;

import com.mongoDb.chatProject.domain.ChattingRoom;
import com.mongoDb.chatProject.repository.ChattingRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class TestController {

    private final ChattingRoomRepository chattingRoomRepository;

    @GetMapping("/find/all/room")
    public String getAllChattingRooms(Model model) {
        List<ChattingRoom> chattingRooms = chattingRoomRepository.findAll();
        model.addAttribute("rooms", chattingRooms);
        return "chat/rooms";
    }
}
