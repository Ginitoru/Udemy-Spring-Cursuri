package main;

import demo.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex1 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach tenisCoach = context.getBean("tenisCoach", Coach.class);

        System.out.println(tenisCoach.getDailyWorkout());

        context.close();

    }
}
