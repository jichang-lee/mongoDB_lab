package com.mongoDb.chatProject.service;

import com.mongoDb.chatProject.domain.ChattingRoom;
import com.mongoDb.chatProject.domain.User;
import com.mongoDb.chatProject.dto.chat.request.CreateRoom;
import com.mongoDb.chatProject.repository.ChattingContentRepository;
import com.mongoDb.chatProject.repository.ChattingRoomRepository;
import com.mongoDb.chatProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatService {

    private final UserRepository userRepository;
    private final ChattingContentRepository chattingContentRepository;
    private final ChattingRoomRepository chattingRoomRepository;


    public void createChatRoom(CreateRoom createRoom) {
        //채팅방 생성시 회원 검증
        createRoom.getMembers().forEach(member -> {
            Optional<User> byUser = userRepository.findById(member.getUserId());
            if (byUser.isEmpty()) {
                log.info("채팅방 생성중 문제된 회원 ={}", member.getUserId());
                throw new IllegalArgumentException("채팅방 생성중 오류가 발생하였습니다.");
            }
        });
        //토큰에서 추출
        ChattingRoom.Member member =
                new ChattingRoom.Member("6908803e6258d420e1ad2dbc","홍성주");

        ChattingRoom chattingRoom = ChattingRoom.builder()
                .master(member)
                .chattingRoomName(createRoom.getChatRoomName())
                .members(createRoom.getMembers())
                .build();

        chattingRoomRepository.save(chattingRoom);
    }
}
