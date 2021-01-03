package com.example.order.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HomeController {

    @PostMapping("/ping")
    public ResponseEntity<String> ping() {
        System.out.println("12312312312313123122313123");
//        return ResponseEntity.status(HttpStatus.OK).body("order ping");
        return new ResponseEntity<>("test", HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<String> test(@RequestBody String username) {
        System.out.println(username + "=======================");
        return ResponseEntity.ok("username Success");
    }
}
