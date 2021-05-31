package com.example.demo.advice;

import com.example.demo.exception.AlreadyExistUsernameException;
import com.example.demo.exception.InvalidUsernameException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ControllerAdvice
public class ControllerExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotFoundException.class)
    public ExceptionResponse handleUserNotFoundException(UserNotFoundException exception) {
        return new ExceptionResponse(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidUsernameException.class)
    public ExceptionResponse handleInvalidUsernameException(InvalidUsernameException exception) {
        return new ExceptionResponse(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(AlreadyExistUsernameException.class)
    public ExceptionResponse handleAlreadyExistUsernameException(AlreadyExistUsernameException exception) {
        return new ExceptionResponse(exception.getMessage());
    }
}
