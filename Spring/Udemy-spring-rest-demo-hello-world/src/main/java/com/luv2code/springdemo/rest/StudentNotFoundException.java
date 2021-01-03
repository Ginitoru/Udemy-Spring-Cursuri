package com.luv2code.springdemo.rest;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException() {

    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}
