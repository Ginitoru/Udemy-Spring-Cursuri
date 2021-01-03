package demo;

import demo.dependency.FortuneService;
import demo.dependency.SadFortuneService;
import demo.dependency.Test3FortuneService;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan("demo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }

    @Bean
    public FortuneService test3FortuneService(){
        return new Test3FortuneService();
    }

    @Bean
    public Coach coach3(){
        return new Coach3(test3FortuneService());
    }
}
