package com.spring.task;

import org.aspectj.lang.ProceedingJoinPoint;

public class aroundAdvice {
    public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("====AroundBefore Method");
        pjp.proceed();
        System.out.println("====AroundAfter Method");
    }
}
