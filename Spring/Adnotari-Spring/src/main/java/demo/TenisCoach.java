package demo;

import demo.dependency.FortuneService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TenisCoach implements Coach, DisposableBean {


    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;


    public TenisCoach() {
    }

    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("inside doMyStartupStuff");
    }

    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("inide myCleanupStuff");
    }




    @Override
    public String getDailyWorkout() {
        return "Practice your backhand voley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("yyyyyyy");
    }
}
