package com.luv2code.aopdemo.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {


    public String getFortune(){


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "HeavyTrafic";
    }


    public String getFortune(boolean tripWire) {

        if(tripWire){

            throw new RuntimeException("BUMMMMMMMM");

        }

        return getFortune();
    }
}
