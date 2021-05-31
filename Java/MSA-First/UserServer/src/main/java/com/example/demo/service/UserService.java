package com.example.demo.service;

import com.example.demo.exception.UsernameDuplicatedException;
import com.example.demo.model.dto.UserRequestData;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserRequestData signUp(UserRequestData requestData) throws UsernameDuplicatedException {
        if (!isAlreadyRegisteredMembership(requestData.getUsername())) {
            User user = modelMapper.map(requestData, User.class);

            return modelMapper.map(userRepository.save(user), UserRequestData.class);
        } else {
            throw new UsernameDuplicatedException();
        }
    }

    private boolean isAlreadyRegisteredMembership(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
