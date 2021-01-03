package com.spring.task;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
    public static void main(String[] args) {

        /* TODO : Spring Container 불러오기
        *  TODO : Container에서 Bean 불러오기
        *  TODO : AOP 실행하기 */

        AbstractApplicationContext container =
                new GenericXmlApplicationContext("/config/context-aop.xml");

        Service app = (Service) container.getBean("service");

        app.firstService();
        app.secondService();
        app.thirdService();
    }
}
