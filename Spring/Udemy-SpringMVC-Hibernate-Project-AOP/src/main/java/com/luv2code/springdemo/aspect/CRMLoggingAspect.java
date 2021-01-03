package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
    private void forControllerPackage(){

    }

    @Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage()|| forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}


    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){

        String theMethod = theJoinPoint.getSignature().toShortString();

        myLogger.info("=========> in @Before: calling method: " + theMethod);

        Object [] args = theJoinPoint.getArgs();

        Arrays.stream(args).forEach( arg -> myLogger.info("======> argument: " + arg));

    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){

        String theMethod = joinPoint.getSignature().toShortString();

        myLogger.info("=========> in @AfterREturning: calling method: " + theMethod);


        myLogger.info("======> result: "+ result);

    }



}
