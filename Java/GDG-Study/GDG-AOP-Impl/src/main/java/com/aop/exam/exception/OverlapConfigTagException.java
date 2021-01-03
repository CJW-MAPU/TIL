package com.aop.exam.exception;

public class OverlapConfigTagException extends Exception {
    public OverlapConfigTagException() {
        super("<config> Tag is Overlap");
    }
}
