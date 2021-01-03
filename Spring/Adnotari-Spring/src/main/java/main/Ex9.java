package main;

import demo.Coach;
import demo.SportConfig;
import demo.SwimCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex9 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);


        try(context){

//            Coach coach = context.getBean("swimCoach", Coach.class);
//
//            System.out.println(coach.getDailyWorkout());
//            System.out.println(coach.getDailyFortune());

            SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);

            System.out.println(coach.getEmail());
            System.out.println(coach.getTeam());



        }
    }
}
