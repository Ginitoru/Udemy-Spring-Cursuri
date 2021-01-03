package demo.dependency;

import demo.dependency.FortuneService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class TestFortuneService implements FortuneService {

    @Value("${fortunex}")
    private String fortune1;

    @Value("${fortuney}")
    private String fortune2;

    @Value("${fortunez}")
    private String fortune3;

    @Override
    public String getFortune() {
         String  [] fortune = {fortune1, fortune2, fortune3};
         Random random = new Random();
        return fortune[random.nextInt(fortune.length)];
    }

    public String getFortune1() {
        return fortune1;
    }

    public String getFortune2() {
        return fortune2;
    }

    public String getFortune3() {
        return fortune3;
    }
}
