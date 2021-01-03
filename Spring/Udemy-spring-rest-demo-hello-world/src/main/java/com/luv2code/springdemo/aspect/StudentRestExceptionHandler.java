package com.luv2code.springdemo.aspect;

import com.luv2code.springdemo.rest.StudentErrorResponse;
import com.luv2code.springdemo.rest.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //nu e nevoie de scan se pune automat pt toate @RestController
public class StudentRestExceptionHandler {

    //add exception handling code

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value()); //-> daca nu este gasit
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        //return ResposeEntity
         return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    //add another exception handler .. to catch any exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value()); //->daca se introduce ceva gresit de client
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResposeEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



}
