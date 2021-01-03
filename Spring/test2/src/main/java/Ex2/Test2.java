package Ex2;

import Ex1.Coach;

import Ex1.GolfCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        Coach coach = context.getBean("golfCoach", Coach.class);

        System.out.println(coach.getDailyFortune());

        context.close();


    }
}
