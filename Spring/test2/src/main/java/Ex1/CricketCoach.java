package Ex1;

public class CricketCoach implements Coach {

    private String emailAdress;
    private String team;

    private FortuneService fortuneService;

    public CricketCoach() {
        System.out.println("Cricket Coach: inside no-arg contrusctor");
    }

    @Override
    public String getDailyWorkout() {
        return "practice fast bowling for 15 min a day";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: inside setter method");
        this.fortuneService = fortuneService;
    }

    public void setEmailAdress(String emailAdress) {
        System.out.println("CricketCoach: inside setter method -email");
        this.emailAdress = emailAdress;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: inside setter method - team");
        this.team = team;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public String getTeam() {
        return team;
    }
}
