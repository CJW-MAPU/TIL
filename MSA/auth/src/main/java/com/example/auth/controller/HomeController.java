package com.example.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @PostMapping("/ping")
    public String ping() {
        return "auth pong!!!!!!!!!!";
    }
}
