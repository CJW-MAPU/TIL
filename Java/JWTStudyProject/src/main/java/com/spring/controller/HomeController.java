package com.spring.controller;

import com.spring.dto.UserVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @PostMapping("/hello")
    public Map<String, String> reqHello(@RequestBody UserVO reqData) throws Exception {
        Map<String, String> resData = new HashMap<>();

        System.out.println(reqData.getId());
        System.out.println(reqData.getPw());

        resData.put("test", "qwe");
        resData.put("asdf", "zxcv");

        return resData;
    }

}
