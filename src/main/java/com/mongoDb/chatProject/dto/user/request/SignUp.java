package com.mongoDb.chatProject.dto.user.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUp {
    private String email;
    private String username;
    private String nickname;
    private Long age;
}
