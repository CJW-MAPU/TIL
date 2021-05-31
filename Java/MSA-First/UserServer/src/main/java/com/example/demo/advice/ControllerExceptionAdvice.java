package com.example.demo.advice;

import com.example.demo.exception.UsernameDuplicatedException;
import com.example.demo.model.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionAdvice {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UsernameDuplicatedException.class)
    public ExceptionResponse handleUsernameDuplicatedException(UsernameDuplicatedException exception) {
        return new ExceptionResponse(exception.getMessage());
    }

}
