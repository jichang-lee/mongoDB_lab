package com.mongoDb.chatProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    private FileInfo fileInfo;

    private LocalDateTime sendTime;

    @Data
    public static class FileInfo {
        private String fileName;
        private String filePath;
    }
}
