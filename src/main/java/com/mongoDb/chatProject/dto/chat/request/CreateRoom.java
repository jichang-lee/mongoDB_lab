package com.mongoDb.chatProject.dto.chat.request;

import com.mongoDb.chatProject.domain.ChattingRoom;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateRoom {
    private String chatRoomName;
    private List<ChattingRoom.Member> members;
}
