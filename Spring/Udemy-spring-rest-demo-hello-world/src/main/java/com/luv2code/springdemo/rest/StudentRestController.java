package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    //define @PostContruct to load the student data only once.
    @PostConstruct //dupa initializare face si metada asta
    public void loadData(){
        students = new ArrayList<>();

        students.add(new Student("gigi", "x"));
        students.add(new Student("fane", "y"));
        students.add(new Student("on", "z"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){

        return students;
    }

    //define endpoint for "/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}") //studentId trebuie sa coincida cu studentId de jos
    public Student getStudent(@PathVariable int studentId){

        if(studentId >= students.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found " + studentId);
        }

        return students.get(studentId);

    }

     //todo:codul de mai jos a fost mutat in @ControllerAdvice pt a putea folosit pt orice controller ->AOP

        //add an axception handler using @ExceptionHandler -> acest cod e folosit cand avem index out of bound exception la lista
        // sau putem sa folosim pt orice alta exceptie
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
//
//        //create a StudentErrorResponse
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.NOT_FOUND.value()); //-> daca nu este gasit
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//
//        //return ResposeEntity
//         return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
//
//
//    //add another exception handler .. to catch any exception
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
//
//        //create a StudentErrorResponse
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.BAD_REQUEST.value()); //->daca se introduce ceva gresit de client
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        //return ResposeEntity
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }


}
