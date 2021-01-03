package com.luv2code.springdemo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//aop pt exceptii
@ControllerAdvice
public class CustomerRestExceptionHandler {

    //add an exception handler for CustomerNotFoundException
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handeleException(CustomerNotFoundException exc){

        //create CustomerErrorResponse
        CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    //add another exception handler ... to catch anu exception (catch all)

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception exc){

        CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);


    }

}
