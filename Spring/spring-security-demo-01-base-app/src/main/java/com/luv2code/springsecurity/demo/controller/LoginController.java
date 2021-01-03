package com.luv2code.springsecurity.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage") //trebuie sa coincida cu pagina din DemoSecurityConfig ->protected void configure(HttpSecurity http)
    public String showMyLoginPage(){

        return "fancy-login";
    }


    @GetMapping("/access-denied")
    public String showAccesDenied(){

        return "access-denied";
    }



}
