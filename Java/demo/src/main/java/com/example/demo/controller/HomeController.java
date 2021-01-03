package com.example.demo.controller;

import com.example.demo.dto.UserVO;
import com.example.demo.response.Response;
import com.example.demo.response.ResponseData;
import com.example.demo.response.ResponseHeader;
import com.example.demo.service.ResponseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    public ResponseService responseService = new ResponseService();

    @PostMapping("/ping")
    public ResponseEntity<Response<?, ?>> ping() {
        UserVO vo = new UserVO();
        vo.setUsername("username");
        vo.setPassword("password");

        Response<ResponseHeader, ResponseData<?>> response = new Response<>();
        response.setHeader(responseService.setHeader());
        response.setBody(responseService.setData(vo));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
