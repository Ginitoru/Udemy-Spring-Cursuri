package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);


        AccountDAO account = context.getBean("accountDAO", AccountDAO.class);

        List<Account> theAccounts = null;

        try{

            boolean tripWire = false;

           theAccounts = account.findAccounts(tripWire);


        }catch (Exception exc){
            System.out.println("Caught exception: "+ exc);
        }


        System.out.println("\n\n Main Program : AfterThrowingDemoApp");
        System.out.println("----------------");

        System.out.println(theAccounts);

        System.out.println("\n");






        context.close();

    }


}
