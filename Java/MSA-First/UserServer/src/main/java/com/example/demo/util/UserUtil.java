package com.example.demo.util;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserUtil {

    public UserDto convertEntityToDto(User user) {
        return UserDto.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
