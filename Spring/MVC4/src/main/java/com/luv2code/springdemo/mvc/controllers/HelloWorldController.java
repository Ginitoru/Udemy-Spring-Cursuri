package com.luv2code.springdemo.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    //need a controller method to show the initial HTML form


    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";

    }

    //need a controller method to process the HTML form

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //add new controller method to read form data  and
    //add data to model

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        //red the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        //create the message
        theName = theName.toUpperCase();

        String result = "Yo ! " + theName;


        //add message to the model

        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(
            @RequestParam("studentName") String theName, Model model){


        theName =theName.toUpperCase();

        String result = "Mwahahahaha " + theName;


        model.addAttribute("message",result);

        return "helloworld";

    }









}
