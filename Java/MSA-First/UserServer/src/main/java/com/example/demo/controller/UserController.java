package com.example.demo.controller;

import com.example.demo.model.dto.UserRequestData;
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
    public UserRequestData signUp(UserRequestData requestData) {
        return userService.signUp(requestData);
    }

    @PostMapping("/ping")
    public String ping() {
        System.out.println("test");

        return "pong";
    }
}
