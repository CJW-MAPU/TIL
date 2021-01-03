package com.spring.service;

import com.spring.dao.UserAuthDAO;
import com.spring.dto.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {
    @Autowired
    private UserAuthDAO userAuthDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO user = userAuthDAO.getUserById(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
}
