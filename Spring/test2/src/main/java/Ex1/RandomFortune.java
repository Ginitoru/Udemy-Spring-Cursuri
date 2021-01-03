package Ex1;

import java.util.Random;

public class RandomFortune implements FortuneService {

    private String [] fortune = {"luck", "bad luck", "fuck"};
    private Random random = new Random();

    @Override
    public String getFortune() {
        return fortune[random.nextInt(fortune.length)];
    }
}
