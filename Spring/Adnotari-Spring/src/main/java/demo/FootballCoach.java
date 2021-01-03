package demo;

import demo.dependency.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return null;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }


    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("in setter");
        this.fortuneService = fortuneService;
    }


    public void doSomething(FortuneService fortuneService){
        fortuneService.getFortune();
        System.out.println("in doSomethingMethod");
    }
}
