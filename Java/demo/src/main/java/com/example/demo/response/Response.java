package com.example.demo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T, V> {
    private T header;
    private V body;
}
