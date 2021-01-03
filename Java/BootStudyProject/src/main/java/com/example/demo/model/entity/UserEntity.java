package com.example.demo.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class UserEntity {
    private int seq;

    private String username;

    private String password;
}
