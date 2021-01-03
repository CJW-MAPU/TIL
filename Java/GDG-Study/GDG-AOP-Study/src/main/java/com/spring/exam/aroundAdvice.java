package com.spring.exam;

import org.aspectj.lang.ProceedingJoinPoint;

public class aroundAdvice {
    public void beforeMethod() {
        System.out.println("before============");
    }
}
