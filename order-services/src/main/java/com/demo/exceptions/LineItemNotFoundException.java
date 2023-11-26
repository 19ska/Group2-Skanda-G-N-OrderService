package com.demo.exceptions;

public class LineItemNotFoundException extends RuntimeException {
    public LineItemNotFoundException(String message) {
        super(message);
    }
}