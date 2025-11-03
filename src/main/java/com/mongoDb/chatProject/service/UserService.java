package com.mongoDb.chatProject.service;

import com.mongoDb.chatProject.domain.User;
import com.mongoDb.chatProject.dto.user.request.SignUp;
import com.mongoDb.chatProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void saveUser(SignUp signUp) {
        Optional<User> findUser = userRepository.findByEmail(signUp.getEmail());
        if (findUser.isPresent()) {
            throw new IllegalArgumentException("이미 가입된 이메일 입니다.");
        }
        User user = User.builder()
                .email(signUp.getEmail())
                .username(signUp.getUsername())
                .nickname(signUp.getNickname())
                .age(signUp.getAge())
                .build();
        userRepository.save(user);
    }

    public Page<User> getAllUser(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }

}