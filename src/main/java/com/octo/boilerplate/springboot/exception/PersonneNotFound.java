package com.octo.boilerplate.springboot.exception;

public class PersonneNotFound extends RuntimeException{
    public PersonneNotFound(String message) {
        super(message);
    }
}
