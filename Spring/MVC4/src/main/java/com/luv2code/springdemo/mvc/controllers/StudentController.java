package com.luv2code.springdemo.mvc.controllers;

import com.luv2code.springdemo.mvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model theModel){
        //creem un obiect de student
        //adaugam obiectul la model

        Student theStundet = new Student();
        

        theModel.addAttribute("student", theStundet);

        return "student-form";

    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        //ia datele din fieldurile din html si le seteaza pe obiectul theStudent cu ajutorul setterilor din clasa Student

        System.out.println("student" + theStudent.getFirstName() + " " + theStudent.getLastName());
        return "student-confirmation";

    }

}
