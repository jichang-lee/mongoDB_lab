package com.mongoDb.chatProject.repository;

import com.mongoDb.chatProject.domain.ChattingContent;
import com.mongoDb.chatProject.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChattingContentRepository extends MongoRepository<ChattingContent,String> {
    List<ChattingContent> findByRoomId(String roomId);
}
