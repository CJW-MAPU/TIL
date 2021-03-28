package com.example.demo.model.entity;

import com.example.demo.model.dto.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

class UserTest {
    private static ModelMapper modelMapper;

    @BeforeAll
    static void createUtilClass() {
        modelMapper = new ModelMapper();
    }

    @Test
    @DisplayName("User DTO 의 올바른 User Entity 변환 테스트")
    public void testModelMapperForUserDtoToUserEntity() {
        UserDto userDto = givenUsernameAndPassword("testUsername", "testPassword");

        User user = whenUserDtoToUserEntityAsModelMapper(userDto);

        thenUserEntityShouldContain(user);
    }

    private UserDto givenUsernameAndPassword(String username, String password) {
        return UserDto.builder()
            .username(username)
            .password(password)
            .build();
    }

    private User whenUserDtoToUserEntityAsModelMapper(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    private void thenUserEntityShouldContain(User user) {
        Assertions.assertAll(
            () -> Assertions.assertEquals(user.getUsername(), "testUsername"),
            () -> Assertions.assertEquals(user.getPassword(), "testPassword")
        );
    }
}