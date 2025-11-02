package com.mongoDb.chatProject.repository;

import com.mongoDb.chatProject.domain.ChattingContent;
import com.mongoDb.chatProject.domain.ChattingRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChattingRoomRepository extends MongoRepository<ChattingRoom,String> {

}
