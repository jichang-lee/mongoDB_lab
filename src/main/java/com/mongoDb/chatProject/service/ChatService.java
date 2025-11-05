package com.mongoDb.chatProject.service;

import com.mongoDb.chatProject.domain.ChattingContent;
import com.mongoDb.chatProject.domain.ChattingRoom;
import com.mongoDb.chatProject.domain.User;
import com.mongoDb.chatProject.dto.chat.request.CreateRoom;
import com.mongoDb.chatProject.dto.chat.request.SendMessage;
import com.mongoDb.chatProject.dto.chat.response.SendMessageResponse;
import com.mongoDb.chatProject.repository.ChattingContentRepository;
import com.mongoDb.chatProject.repository.ChattingRoomRepository;
import com.mongoDb.chatProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public SendMessageResponse sendMessage(SendMessage sendMessage) {
        User userById = findUserById(sendMessage.getMemberId());
        if (userById == null) {
            log.info("채팅 메세지 전송중 문제된 회원 ={}", sendMessage.getMemberId());
            throw new IllegalArgumentException("채팅 메세지 발송중 문제가 발생하였습니다.");
        }
        ChattingContent chattingContent = ChattingContent.builder()
                .roomId(sendMessage.getRoomId())
                .memberId(sendMessage.getMemberId())
                .nickName(userById.getUsername())
                .message(sendMessage.getMessage())
                .messageType("text/plain")
                .build();
        ChattingContent saveMessage = chattingContentRepository.save(chattingContent);
        ChattingRoom.LatestMessage latestMessage = ChattingRoom.LatestMessage.builder()
                .nickname(userById.getUsername())
                .latestMessage(saveMessage.getMessage())
                .latestMessageTime(saveMessage.getSendTime())
                .build();
        chattingRoomRepository.findById(sendMessage.getRoomId())
                .ifPresent(room -> {
                    room.setLatestMessage(latestMessage);
                    chattingRoomRepository.save(room); // 업데이트
                });

        chattingRoomRepository.findById(sendMessage.getRoomId())
                .ifPresent(room -> {
                    room.setLatestMessage(latestMessage);
                    chattingRoomRepository.save(room); // 업데이트
                });
        return SendMessageResponse.builder()
                .roomId(saveMessage.getRoomId())
                .memberId(saveMessage.getMemberId())
                .nickname(saveMessage.getNickName())
                .message(saveMessage.getMessage())
                .messageType("text/plain")
                .sendTime(saveMessage.getSendTime())
                .build();
    }

    public User findUserById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
