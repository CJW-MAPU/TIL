package com.example.demo.exception;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException() {
        super("Token is Invalid");
    }
}
