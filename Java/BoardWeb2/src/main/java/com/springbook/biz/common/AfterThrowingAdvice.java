package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
    @Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
    public void allPointcut() {}

    @AfterThrowing(pointcut = "allPointcut()", throwing = "exceptObj")
    public void exceptionLog(JoinPoint jp, Exception exceptObj) {
        String method = jp.getSignature().getName();
        System.out.println(method + "() 메소드 실행 중 예외 발생!");

        if(exceptObj instanceof IllegalArgumentException) {
            System.out.println("부적합한 값이 입력되엇습니다.");
        } else if(exceptObj instanceof NumberFormatException) {
            System.out.println("숫자 형식의 값이 아닙니다.");
        } else if(exceptObj instanceof Exception) {
            System.out.println("문제가 발생하였습니다.");
        }
    }
}
