package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {


    public void addAccount(Account theAccount, boolean vipFlag){

        System.out.println(getClass() + " : DOIN MY DB WORK: ADDING  AN ACCOUNT");
    }

//    public void addAccount(){
//
//        System.out.println(getClass() + " : DOIN MY DB WORK: ADDING  AN ACCOUNT");
//    }

    public boolean doWork(){

        System.out.println(getClass() + " : doing work");

        return false;
    }

}
