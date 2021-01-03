package com.example.member.controller;

import com.example.member.model.dto.MemberDto;
import com.example.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/sign-up")
    public MemberDto register(@RequestBody MemberDto memberDto) {
        return memberService.save(memberDto.toEntity());
    }
}