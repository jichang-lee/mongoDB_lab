package com.mongoDb.chatProject.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "chatting_content")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChattingContent {
    @Id
    private String id;

    private String roomId;

    private String memberId;

    private String nickName;

    private String message;
    //enum
    private String messageType;

//    private FileInfo fileInfo;

    private LocalDateTime sendTime;

    @Data
    public static class FileInfo {
        private String fileName;
        private String filePath;
    }

    @Builder
    public ChattingContent(String roomId, String memberId, String nickName, String message, String messageType) {
        this.roomId = roomId;
        this.memberId = memberId;
        this.nickName = nickName;
        this.message = message;
        this.messageType = messageType;
        this.sendTime = LocalDateTime.now();
    }
}
