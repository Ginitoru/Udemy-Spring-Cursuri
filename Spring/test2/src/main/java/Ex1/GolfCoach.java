package Ex1;

import org.springframework.beans.factory.DisposableBean;

public class GolfCoach implements Coach, DisposableBean {

    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "run run run";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void initMethod(){
        System.out.println("initMethod");
    }

    public void destroyMethod(){
        System.out.println("destroy method1");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy motherfucker:D");
    }
}
