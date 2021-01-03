package com.example.demo.service;

import com.example.demo.dto.TodoVO;
import com.example.demo.dto.UserVO;
import com.example.demo.response.ResponseData;
import com.example.demo.response.ResponseHeader;

public class ResponseService {

    public ResponseHeader setHeader() {
        ResponseHeader responseHeader = new ResponseHeader();

        responseHeader.setTime("2020-01-01");
        responseHeader.setFlag("OK");

        return responseHeader;
    }

    public <T> ResponseData<T> setData(T data) {
        ResponseData<T> responseData = new ResponseData<>();

        responseData.setData(data);

        return responseData;
    }
}
