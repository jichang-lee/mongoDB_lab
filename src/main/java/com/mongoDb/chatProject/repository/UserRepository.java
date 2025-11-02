package com.mongoDb.chatProject.repository;

import com.mongoDb.chatProject.domain.ChattingContent;
import com.mongoDb.chatProject.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

}
