package com.mongoDb.chatProject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

    private String username;

    private Long age;
}
