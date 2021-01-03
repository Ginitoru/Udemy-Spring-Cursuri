package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //aici adaugam toate "advices-urile" pt logging

  //  @Before("execution(public void addAccount())") -> pt orice metoda addAccount() din orice clasa care e scanata

 //   @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())") //-> doar pentru pentru metoda addAccount() din acel pachet si aceea clasa

 //   @Before("execution(public void add*())")  //-> pt orice metoda care incepe cu add din orice clasa

 //   @Before("execution(* add*())") //-> pt orice return type (modify-eru nu apare pt ca e optional -> steluta pt el)

 //   @Before("execution(* add*(com.luv2code.aopdemo.Account))") // pt orice metoda care incepe cu "add" si care primeste un parametru de obiect "Account din pachetul com.luv2code.aopdemo"
 //   @Before("execution(* add*(com.luv2code.aopdemo.Account, ..))") // metoda trebuie sa aiba un parametru de tip Account si oricati parametrii dupa

//    @Before("execution(* add*(..))")  // -> match cu orice parametru

    @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") // -> se potriveste pentru orice clasa si orice metoda cu oricati parametrii din pachetul com.luv2code.aopdemo.dao
    public void beforeAddACcountAdvice(){

        System.out.println("\n========> Executing @Before advice on addAccount()");

    }






}
