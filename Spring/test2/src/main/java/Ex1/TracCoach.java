package Ex1;

public class TracCoach implements Coach {

    private FortuneService fortuneService;

    public TracCoach() {
    }

    public TracCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it "+ fortuneService.getFortune();
    }

    public void doMyStartupStuff(){
        System.out.println("TrackCoach: inside method doMyStartupStuff");
    }

    public void doMyClanUpStuffYoYo(){
        System.out.println("TackCoach: inside method domyCleanupYoYo");
    }
}
