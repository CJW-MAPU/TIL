package com.example.demo.exception;

public class InvalidUsernameException extends RuntimeException {
    public InvalidUsernameException() {
        super("유효하지 않은 Username 입니다");
    }
}
