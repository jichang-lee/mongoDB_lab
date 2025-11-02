package com.mongoDb.chatProject.controller;

import com.mongoDb.chatProject.domain.User;
import com.mongoDb.chatProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;


    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/find/all")
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
