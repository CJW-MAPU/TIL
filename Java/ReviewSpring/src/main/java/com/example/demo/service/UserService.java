package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;



    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
