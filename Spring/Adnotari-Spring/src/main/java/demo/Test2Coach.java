package demo;

import demo.dependency.FortuneService;
import demo.dependency.TestFortune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Test2Coach implements Coach {

    @Autowired
    @Qualifier("test2FortuneService")
    private TestFortune testFortune;


    @Override
    public String getDailyWorkout() {
        return null;
    }

    @Override
    public String getDailyFortune() {
        return null;
    }

    @PostConstruct
    public void getFortune2(){
        testFortune.fortuneTwo();
    }


}
