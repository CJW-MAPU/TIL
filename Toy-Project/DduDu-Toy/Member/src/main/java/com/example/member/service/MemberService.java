package com.example.member.service;

import com.example.member.model.dto.MemberDto;
import com.example.member.model.entity.Member;
import com.example.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public ResponseEntity<MemberDto> findByUsername(String username) {
        Member member = memberRepository.findByUsername(username);

        MemberDto res = MemberDto.builder()
                .username(member.getUsername())
                .password(member.getPassword())
                .build();

        return ResponseEntity.ok(res);
    }

    public MemberDto save(Member member) {
        System.out.println(member.toString());
        Member memberCheck = memberRepository.save(member);

        return MemberDto.builder()
                .id(memberCheck.getId())
                .username(memberCheck.getUsername())
                .password(memberCheck.getPassword())
                .name(memberCheck.getName())
                .email(memberCheck.getEmail())
                .build();
    }
}
