package com.example.demo.exception;

public class UsernameDuplicatedException extends RuntimeException {
    public UsernameDuplicatedException() {
        super("이미 존재하는 Username 입니다");
    }
}
