package demo;

import demo.dependency.FortuneService;

public class Coach3 implements Coach {

    private FortuneService fortuneService;


    public Coach3(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return null;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
