package com.aop.exam.exception;

public class BeanNotFoundException extends Exception {
    public BeanNotFoundException() {
        super("Bean in XML is NOT Found");
    }
}
