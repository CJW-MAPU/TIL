package com.example.demo.service;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.UserUtil;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserUtil userUtil;

    public UserService(UserRepository userRepository, UserUtil userUtil) {
        this.userRepository = userRepository;
        this.userUtil = userUtil;
    }

    public UserDto signUp(User user) {
        if (!isAlreadyRegisteredMembership(user.getUsername())) {
            return userUtil.convertEntityToDto(userRepository.save(user));
        } else {
            return userUtil.convertEntityToDto(user);
        }
    }

    private boolean isAlreadyRegisteredMembership(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
