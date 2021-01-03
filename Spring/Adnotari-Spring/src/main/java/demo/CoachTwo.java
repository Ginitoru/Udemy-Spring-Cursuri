package demo;

import demo.dependency.FortuneService;
import demo.dependency.TestFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CoachTwo implements Coach{

    @Autowired
    @Qualifier("testFortuneService")
    private FortuneService fortuneService;


    @Value("${fortunex}")
    String xxx;

    public CoachTwo() {
    }

    @Override
    public String getDailyWorkout() {
        return xxx;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
