package com.aop.exam.exception;

public class OverlapPointcutIDException extends Exception {
    public OverlapPointcutIDException() {
        super("Two or More Pointcut IDs Overlap");
    }
}
