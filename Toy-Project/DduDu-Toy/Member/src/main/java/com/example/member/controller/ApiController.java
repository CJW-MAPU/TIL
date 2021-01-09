package com.example.member.controller;

import com.example.member.model.dto.MemberDto;
import com.example.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.OncePerRequestFilter;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiController {

    @Autowired
    MemberService memberService;

    @GetMapping("/{username}")
    public ResponseEntity<MemberDto> findByUsername(@PathVariable("username") String username) {
        System.out.println("qweqweqeqeqeqweqeqweqweqeqeq");
        return memberService.findByUsername(username);
    }
}
