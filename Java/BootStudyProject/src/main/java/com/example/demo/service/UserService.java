package com.example.demo.service;

import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired UserRepository userRepository;

    public Map<String, String> loginCheck(UserEntity userEntity) throws Exception {
        Map<String, String> map = new HashMap<>();

        /*if (userRepository.getUser(userEntity) == 1) {
            map.put("flag", "true");
            map.put("username", userEntity.getUsername());
            map.put("error", null);
        } else {
            map.put("flag", "false");
            map.put("username", null);
            map.put("error", "Invalid Username or Password");
        }*/
        String username = userRepository.getUser(userEntity);

        System.out.println(username);

        map.put("username", username);

        return map;
    }
}
