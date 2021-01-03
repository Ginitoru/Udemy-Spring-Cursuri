package main;

import demo.Coach;
import demo.SportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex8 {

    //config app
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        try(context){

            Coach coach = context.getBean("tenisCoach", Coach.class);

            System.out.println(coach.getDailyFortune() + " xxx");
        }
    }
}
