package com.example.demo.model.dto;

import com.example.demo.model.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestData {

    private String username;
    private String password;
}
