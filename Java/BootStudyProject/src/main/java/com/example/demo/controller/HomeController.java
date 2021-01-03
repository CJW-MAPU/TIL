package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @Autowired UserService userService;

    @PostMapping("/api/test")
    public void test() {

    }

    @PostMapping("/api/login")
    public Map<String, String> reqLogin(@RequestBody UserDto userDto) throws Exception {
        return userService.loginCheck(userDto.toEntity());
    }

}
