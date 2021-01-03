package main;

import demo.Coach;
import demo.Test2Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex7 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


        try(context){
            Test2Coach coach = context.getBean("test2Coach", Test2Coach.class);



        }


    }
}
