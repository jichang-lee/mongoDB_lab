package com.mongoDb.chatProject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

    private String email;

    private String username;

    private String nickname;

    private Long age;

    private LocalDateTime createdAt;

    @Builder
    public User(String email, String username, String nickname, Long age) {
        this.email = email;
        this.username = username;
        this.nickname = nickname;
        this.age = age;
        this.createdAt = LocalDateTime.now();
    }
}

