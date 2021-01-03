package com.luv2code.springdemo.error;

public class CustomerNotFoundException extends RuntimeException {


    public CustomerNotFoundException(String message) {
        super(message);
    }

}
