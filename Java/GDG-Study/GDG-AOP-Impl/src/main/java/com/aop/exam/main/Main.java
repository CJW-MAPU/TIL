package com.aop.exam.main;

import com.aop.exam.util.MySpringContainer;

public class Main {
    public static void main(String[] args) throws Exception {
        MySpringContainer container
                = new MySpringContainer("./src/main/resources/config/applicationContext.xml");

        BeanService app = (BeanService) container.getBean("beanService");

        app.hi();
        app.bye();
    }
}
