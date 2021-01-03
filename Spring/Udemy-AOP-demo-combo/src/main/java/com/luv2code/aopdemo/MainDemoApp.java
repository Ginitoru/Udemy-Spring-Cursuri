package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);



        accountDAO.addAccount(new Account(), true);

        accountDAO.doWork();

        membershipDAO.addSilly();


        membershipDAO.goToSleep();

        System.out.println("\n*******************************\n");

       accountDAO.setName("foobar");
       accountDAO.setServiceCode("silver");

        System.out.println(accountDAO.getName());
        System.out.println(accountDAO.getServiceCode());




        context.close();



    }
}
