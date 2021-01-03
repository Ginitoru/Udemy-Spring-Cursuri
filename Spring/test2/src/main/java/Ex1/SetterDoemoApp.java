package Ex1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDoemoApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext contexct = new ClassPathXmlApplicationContext("applicationContext.xml");

        CricketCoach cricketCoach = contexct.getBean("myCricketCoach", CricketCoach.class);

        System.out.println(cricketCoach.getDailyWorkout());
        System.out.println(cricketCoach.getDailyFortune());
        System.out.println(cricketCoach.getEmailAdress());
        System.out.println(cricketCoach.getTeam());


        contexct.close();


    }
}
