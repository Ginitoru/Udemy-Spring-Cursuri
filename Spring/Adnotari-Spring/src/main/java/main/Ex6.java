package main;

import demo.Coach;
import demo.CoachTwo;
import demo.dependency.TestFortuneService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex6 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach coach = context.getBean("coachTwo", Coach.class);


        System.out.println(coach.getDailyFortune());
      //  System.out.println(coach.getDailyWorkout());






        context.close();




    }
}
