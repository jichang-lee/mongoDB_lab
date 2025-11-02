package com.mongoDb.chatProject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "chatting_room")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChattingRoom {

    @Id
    private String id;

    private String chattingRoomName;

    private User user;

    private LocalDateTime createAt;
}
