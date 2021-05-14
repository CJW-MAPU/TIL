package com.example.demo.controller;

import com.example.demo.model.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public UserDto signUp(UserDto request) {
        return userService.signUp(request.toEntity());
    }

    @PostMapping("/ping")
    public String ping() {
        System.out.println("test");

        return "pong";
    }
}
