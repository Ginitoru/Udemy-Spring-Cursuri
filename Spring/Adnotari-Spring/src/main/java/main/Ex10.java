package main;

import demo.Coach;
import demo.SportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex10 {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        try(context){

            Coach coach = context.getBean("coach3", Coach.class);

            System.out.println(coach.getDailyFortune());


        }


    }
}
