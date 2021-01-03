package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.util.GenericSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {




    @Before("com.luv2code.aopdemo.aspect.LuvAopExpression.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){

        System.out.println("\n==========> Executing @Before advice on metod + xxxxx");

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature(); // semantura metodei

        System.out.println("MetodSignature: " + methodSignature);

        Object [] args = theJoinPoint.getArgs();

        for(Object tempArg: args){

            if(tempArg instanceof Account){
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }

            System.out.println(tempArg);


        }

    }















}
