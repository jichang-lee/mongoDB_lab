package com.mongoDb.chatProject.repository;

import com.mongoDb.chatProject.domain.ChattingContent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChattingContentRepository extends MongoRepository<ChattingContent,String> {

}
