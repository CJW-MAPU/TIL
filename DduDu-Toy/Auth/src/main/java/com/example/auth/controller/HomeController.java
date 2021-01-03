package com.example.auth.controller;

import com.example.auth.model.response.Member;
import com.example.auth.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HomeController {
    @Autowired
    JwtUserDetailsService userDetailsService;

    @PostMapping
    public ResponseEntity<String> ping() {
        return ResponseEntity.status(HttpStatus.OK).body("pong");
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Member> register(@RequestBody Member member) {
        return userDetailsService.register(member);
    }
}
