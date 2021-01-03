package main;

import demo.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeApp {
    public static void main(String[] args) {

        try(
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");)
        {

            Coach theCoach = context.getBean("tenisCoach", Coach.class);

            Coach aplhaCoach = context.getBean("tenisCoach",Coach.class);

            System.out.println(theCoach);
            System.out.println(aplhaCoach);

        }

    }
}
