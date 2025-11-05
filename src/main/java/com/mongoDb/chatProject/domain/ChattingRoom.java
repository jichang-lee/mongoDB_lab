package com.mongoDb.chatProject.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "chatting_room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChattingRoom {

    @Id
    private String id;

    private String chattingRoomName;

    private Member master;

    private List<Member> members;

    private LatestMessage latestMessage;

    private LocalDateTime createAt;

    @Data
    @AllArgsConstructor
    @Builder
    public static class Member {
        private String userId;
        private String username;
    }

    // 채팅방 조회시 텍스트 미리보기용
    @Data
    @Builder
    public static class LatestMessage{
        private String nickname;
        private String latestMessage;
        private LocalDateTime latestMessageTime;
    }

    @Builder
    public ChattingRoom(Member master,String chattingRoomName, List<Member> members) {
        this.master = master;
        this.chattingRoomName = chattingRoomName;
        this.members = members;
        this.createAt = LocalDateTime.now();
    }
}
