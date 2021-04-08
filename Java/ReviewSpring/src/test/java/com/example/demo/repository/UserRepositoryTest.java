package com.example.demo.repository;

import com.example.demo.DemoApplicationTests;
import com.example.demo.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserRepositoryTest extends DemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void testRegister() {

        // given
        User user = User.builder()
                .username("testUser")
                .password("password")
                .build();

        // when
        User test = userRepository.save(user);

        // then
        assertNotNull(test);
    }
}