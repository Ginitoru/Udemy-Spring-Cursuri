package main;

import demo.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach coach = context.getBean("volleyCoach", Coach.class);

        System.out.println(coach.getDailyWorkout());




    }
}
