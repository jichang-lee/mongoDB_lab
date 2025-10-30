package com.mongoDb.chatProject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chatting_content")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChattingContent {
    @Id
    private String id;

    private String name;

    private Long age;

    public ChattingContent(String name, Long age) {
        this.name = name;
        this.age = age;
    }
}
