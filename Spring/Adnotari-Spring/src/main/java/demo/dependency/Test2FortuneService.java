package demo.dependency;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Test2FortuneService implements TestFortune{

    @Value("${fortunex}")
    private String fortune;

    @Override
    public void fortuneTwo() {
        System.out.println(fortune  + " merge boss");
    }
}
