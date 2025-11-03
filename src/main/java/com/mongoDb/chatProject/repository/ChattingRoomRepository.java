package com.mongoDb.chatProject.repository;

import com.mongoDb.chatProject.domain.ChattingRoom;
import com.mongoDb.chatProject.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChattingRoomRepository extends MongoRepository<ChattingRoom,String> {
}
