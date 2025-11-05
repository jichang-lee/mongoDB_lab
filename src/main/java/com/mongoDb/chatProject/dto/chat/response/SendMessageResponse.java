package com.mongoDb.chatProject.dto.chat.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SendMessageResponse {
    private String roomId;
    private String memberId;
    private String nickname;
    private String message;
    private String messageType;
    private LocalDateTime sendTime;
}
