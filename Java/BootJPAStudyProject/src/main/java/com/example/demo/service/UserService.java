package com.example.demo.service;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired UserRepository userRepository;

    public Map<String, String> create(UserDto userDto) throws Exception {
        Map<String, String> resData = new HashMap<>();
        User userEntity = userRepository.save(userDto.toEntity());

        if (userEntity.getUsername().equals(userDto.getUsername())) {
            resData.put("username", userEntity.getUsername());
            resData.put("flag", "true");
            resData.put("message", "Success Create User!");
        } else {
            resData.put("username", null);
            resData.put("flag", "false");
            resData.put("message", "Failed Create User!");
        }

        return resData;
    }

    public Map<String, String> checkDup(UserDto userDto) throws Exception {
        Map<String, String> resData = new HashMap<>();
        User user = userDto.toEntity();

        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());

        optionalUser.ifPresentOrElse(value -> {
            resData.put("flag", "true");
            resData.put("message", "You Can Create User!");
        }, () -> {
            resData.put("flag", "false");
            resData.put("message", "You Can't Create User!");
        });

        return resData;
    }

    public Map<String, String> login(UserDto userDto){
        Map<String, String> resData = new HashMap<>();
        User user = userDto.toEntity();

        Optional<User> optionalUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        optionalUser.ifPresentOrElse(value -> {
            resData.put("username", userDto.getUsername());
            resData.put("flag", "true");
            resData.put("message", "Login Success!");
        }, () -> {
            resData.put("username", null);
            resData.put("flag", "false");
            resData.put("message", "Check username or password!");
        });

        return resData;
    }

}
