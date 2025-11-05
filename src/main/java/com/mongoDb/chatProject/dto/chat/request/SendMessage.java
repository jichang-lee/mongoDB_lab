package com.mongoDb.chatProject.dto.chat.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SendMessage {
    private String roomId;
    private String memberId;
    private String message;
}
