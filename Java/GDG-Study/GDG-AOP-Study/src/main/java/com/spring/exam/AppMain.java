package com.spring.exam;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        AbstractApplicationContext container =
                new GenericXmlApplicationContext("/config/context-aop.xml");

//        Service app = (Service) container.getBean("service");
        aroundAdvice app = (aroundAdvice) container.getBean("aroundAdvice");

        app.beforeMethod();

        /*app.hi();
        app.bye();*/
    }
}