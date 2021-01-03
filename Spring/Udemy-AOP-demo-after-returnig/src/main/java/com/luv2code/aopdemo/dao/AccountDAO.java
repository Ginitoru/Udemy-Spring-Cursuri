package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {


    private String name;

    private String serviceCode;



    public List<Account> findAccounts(){

        List<Account> myAccouns = new ArrayList<>();

        Account  account1 = new Account("john", "silver");
        Account  account2 = new Account("luca", "gold");
        Account  account3 = new Account("gigi", "platnum");

        myAccouns.add(account1);
        myAccouns.add(account2);
        myAccouns.add(account3);

        return myAccouns;


    }






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

    public String getName() {
        System.out.println(getClass() + " : getNAme");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " : getCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : setCode");
        this.serviceCode = serviceCode;
    }
}
