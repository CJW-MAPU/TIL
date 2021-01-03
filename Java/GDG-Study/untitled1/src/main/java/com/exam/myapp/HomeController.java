package com.exam.myapp;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements Controller {
    @Autowired
    private MyService myService;

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String no = request.getParameter("myNo");

        return "index";
    }
}
