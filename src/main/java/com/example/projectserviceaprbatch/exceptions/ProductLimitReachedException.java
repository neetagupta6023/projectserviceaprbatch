package com.example.projectserviceaprbatch.exceptions;

public class ProductLimitReachedException extends Exception {
    public ProductLimitReachedException(String message) {
        super(message);
    }
}
