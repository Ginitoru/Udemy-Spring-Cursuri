package main;

import demo.Coach;
import demo.TenisCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex3 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TenisCoach coach = context.getBean("tenisCoach", TenisCoach.class);

        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getEmail() + " " + coach.getTeam());

        context.close();

    }
}
