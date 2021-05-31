package com.example.demo.exception;

public class AlreadyExistUsernameException extends RuntimeException {
    public AlreadyExistUsernameException() {
        super("이미 존재하는 유저입니다.");
    }
}
