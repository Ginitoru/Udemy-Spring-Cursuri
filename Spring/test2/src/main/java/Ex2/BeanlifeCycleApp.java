package Ex2;

import Ex1.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanlifeCycleApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        Coach theCoach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);

//        boolean result = theCoach == alphaCoach;
//        System.out.println(theCoach);
//        System.out.println(alphaCoach);
//
//        System.out.println(result);

        System.out.println(theCoach.getDailyWorkout());


        context.close();

    }
}
