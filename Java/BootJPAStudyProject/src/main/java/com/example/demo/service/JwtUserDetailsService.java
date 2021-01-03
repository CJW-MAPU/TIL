package com.example.demo.service;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);

        UserDto userDto = new UserDto();

        userOptional.ifPresentOrElse(value -> {
            userDto.setUsername(value.getUsername());
            userDto.setPassword(value.getPassword());
        }, () -> {
            throw new UsernameNotFoundException("Check username & password");
        });

        return new org.springframework.security.core.userdetails.User(userDto.getUsername(), userDto.getPassword(), new ArrayList<>());
    }

    public UserDto loginUser(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        UserDto userDto = new UserDto();
        userOptional.ifPresentOrElse(value -> {
            UserDto.builder()
                    .username(value.getUsername())
                    .password(value.getPassword())
                    .build();
        }, () -> {

        });
        return userDto;
    }
}
