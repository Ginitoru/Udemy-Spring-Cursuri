package main;

import demo.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Ex4 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach coach = context.getBean("footballCoach", Coach.class);

        System.out.println(coach.getDailyFortune());

        context.close();
    }
}
