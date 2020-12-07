package com.forttiori.Exceptions;

public class PlanetNotFoundException extends RuntimeException{
    public PlanetNotFoundException(String message) {
        super(message);
    }
}
