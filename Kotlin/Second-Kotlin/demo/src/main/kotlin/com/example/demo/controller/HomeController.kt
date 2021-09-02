package com.example.demo.controller

import com.example.demo.service.HomeService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController(
    private val homeService: HomeService
) {

    @PostMapping("/test")
    fun test() : String = homeService.serviceTest()
}