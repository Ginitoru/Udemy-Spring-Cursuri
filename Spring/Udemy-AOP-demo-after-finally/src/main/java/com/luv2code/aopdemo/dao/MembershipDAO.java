package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {


   public void addAccount(){

       System.out.println(getClass() + " : DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
   }

   public boolean addSilly(){

       System.out.println(getClass() + " : SYLLY METOD ");

       return true;
   }


   public void goToSleep(){
       System.out.println(getClass() + " : going to sleep ");
   }


}
