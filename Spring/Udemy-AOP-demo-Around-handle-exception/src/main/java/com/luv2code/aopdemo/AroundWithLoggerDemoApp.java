package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {


    private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);




        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        String data = fortuneService.getFortune();

        myLogger.info("My Fortune is: " + data);

        myLogger.info("My Fortune is: " + data);


        context.close();

    }


}
