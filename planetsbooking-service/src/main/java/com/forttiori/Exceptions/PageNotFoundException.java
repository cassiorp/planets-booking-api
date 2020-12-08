package com.forttiori.Exceptions;

public class PageNotFoundException extends RuntimeException{
    public PageNotFoundException(String message) {
        super(message);
    }
}
