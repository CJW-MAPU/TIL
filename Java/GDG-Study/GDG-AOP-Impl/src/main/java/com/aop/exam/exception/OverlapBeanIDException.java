package com.aop.exam.exception;

public class OverlapBeanIDException extends Exception {
    public OverlapBeanIDException() {
        super("Two or More Bean IDs Overlap");
    }
}
