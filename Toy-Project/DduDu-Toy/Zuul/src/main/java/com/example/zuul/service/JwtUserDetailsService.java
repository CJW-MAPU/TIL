package com.example.zuul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*
         * TODO : RestTemplate 으로 Member Server에 username을 사용하여 Request하고 Response로 Member 객체를 리턴받는다.
         */

        /*
         * TODO : null에 Response로 받은 Member 객체의 Username 과 Password가 삽입된다.
         */
        return new User(null, null, new ArrayList<>());
    }
}
