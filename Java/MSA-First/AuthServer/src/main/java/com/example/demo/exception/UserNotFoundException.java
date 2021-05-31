package com.example.demo.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("해당하는 유저를 찾지 못했습니다.");
    }
}
