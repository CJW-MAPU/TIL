package com.example.demo.controller;

import com.example.demo.model.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    @Autowired UserService userService;

    @PostMapping("/test")
    public String test() {
        System.out.println("test Success");
        return "test Success";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody UserDto userDto) throws Exception {
        return userService.login(userDto);
    }

    @PostMapping("/create")
    public Map<String, String> create(@RequestBody UserDto userDto) throws Exception {
        return userService.create(userDto);
    }

    @PostMapping("/checkDup")
    public Map<String, String> checkDup(@RequestBody UserDto userDto) throws Exception {
        return userService.checkDup(userDto);
    }

}
