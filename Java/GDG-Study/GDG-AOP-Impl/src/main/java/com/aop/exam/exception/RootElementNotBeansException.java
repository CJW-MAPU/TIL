package com.aop.exam.exception;

public class RootElementNotBeansException extends Exception {
    public RootElementNotBeansException() {
        super("Root Element in XML file is not <beans>");
    }
}
