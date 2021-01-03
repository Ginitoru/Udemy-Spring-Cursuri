package com.luv2code.springbootdemo.UdemiSpringBoot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    //expose a "/" that returns a "Helloo World"
    @GetMapping("/")
    public String sayHello(){

        return "Hellow world! Time server is " + LocalDateTime.now();

    }

}
