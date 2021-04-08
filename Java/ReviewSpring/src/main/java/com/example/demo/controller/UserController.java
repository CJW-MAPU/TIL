package com.example.demo.controller;

import com.example.demo.model.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/user/register")
    public UserDto register(@RequestBody UserDto request) {
        return request;
    }

    UserController(UserService userService) {
        this.userService = userService;
    }
}
