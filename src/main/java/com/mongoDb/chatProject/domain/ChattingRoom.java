package com.mongoDb.chatProject.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "chatting_room")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChattingRoom {

    @Id
    private String id;

    private String chattingRoomName;

    private List<Member> members;

    private LatestMessage latestMessage;

    private LocalDateTime createAt;

    @Data
    @Builder
    public static class Member {
        private String userId;
        private String username;
    }

    // 채팅방 조회시 텍스트 미리보기용
    @Data
    public static class LatestMessage{
        private String nickname;
        private String latestMessage;
        private LocalDateTime latestMessageTime;
    }
}
