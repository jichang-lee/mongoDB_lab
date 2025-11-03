package com.mongoDb.chatProject.controller;

import com.mongoDb.chatProject.domain.User;
import com.mongoDb.chatProject.dto.user.SignUp;
import com.mongoDb.chatProject.repository.UserRepository;
import com.mongoDb.chatProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public void save(@RequestBody SignUp signUp) {
        userService.saveUser(signUp);
    }

    @GetMapping("/find/all")
    public Page<User> findAll(@RequestParam int page,
                              @RequestParam int size
    ) {
        return userService.getAllUser(page,size);
    }
}
