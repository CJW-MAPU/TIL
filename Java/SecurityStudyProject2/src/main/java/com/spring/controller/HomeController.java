package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/secu/loginPage")
    public String loginPage() throws Exception {
        return "loginPage.jsp";
    }

    @RequestMapping(value = "/page")
    public String page() throws Exception {
        return "page.jsp";
    }

    @RequestMapping(value = "/user/page")
    public String userPage() throws Exception {
        return "userPage.jsp";
    }

    @RequestMapping(value = "/member/page")
    public String memberPage() throws Exception {
        return "memberPage.jsp";
    }

    @RequestMapping(value = "/admin/page")
    public String adminPage() throws Exception {
        return "adminPage.jsp";
    }

    @RequestMapping(value = "/access_denied_page")
    public String accessDeniedPage() throws Exception {
        return "access_denied_page.jsp";
    }
}
