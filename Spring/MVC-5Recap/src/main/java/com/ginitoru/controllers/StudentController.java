package com.ginitoru.controllers;

import com.ginitoru.model.Student;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

    }

    @RequestMapping("/showForm")
    public String showForm(Model model){

        model.addAttribute("student", new Student());

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("student") Student theStudent,
            BindingResult theBindingresult){

            if(theBindingresult.hasErrors()){
                return "student-form";
            }

        return "student-confirmation";
    }
}
