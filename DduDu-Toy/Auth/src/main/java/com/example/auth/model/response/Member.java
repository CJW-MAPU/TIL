package com.example.auth.model.response;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Member {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String email;
}
