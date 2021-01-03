package Ex1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach coach = context.getBean("golfCoach", Coach.class);

        System.out.println(coach.getDailyFortune());

        context.close();

    }
}
