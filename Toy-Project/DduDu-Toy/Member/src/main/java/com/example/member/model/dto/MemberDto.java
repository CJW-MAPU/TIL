package com.example.member.model.dto;

import com.example.member.model.entity.Member;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberDto {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String email;

    public Member toEntity() {
        return Member.builder()
                .username(username)
                .password(password)
                .name(name)
                .email(email)
                .build();
    }
}
