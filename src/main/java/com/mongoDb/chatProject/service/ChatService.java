package com.mongoDb.chatProject.service;

import com.mongoDb.chatProject.repository.ChattingContentRepository;
import com.mongoDb.chatProject.repository.ChattingRoomRepository;
import com.mongoDb.chatProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final UserRepository userRepository;
    private final ChattingContentRepository chattingContentRepository;
    private final ChattingRoomRepository chattingRoomRepository;



}
