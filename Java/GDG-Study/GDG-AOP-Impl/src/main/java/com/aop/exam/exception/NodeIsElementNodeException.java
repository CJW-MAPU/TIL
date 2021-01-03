package com.aop.exam.exception;

public class NodeIsElementNodeException extends Exception {
    public NodeIsElementNodeException() {
        super("Node in NodeList is not ELEMENT_NODE");
    }
}
