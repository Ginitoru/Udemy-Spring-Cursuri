package demo;

import org.springframework.stereotype.Component;

@Component
public class VolleyCoach implements Coach{


    @Override
    public String getDailyWorkout() {
        return "play play play";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
