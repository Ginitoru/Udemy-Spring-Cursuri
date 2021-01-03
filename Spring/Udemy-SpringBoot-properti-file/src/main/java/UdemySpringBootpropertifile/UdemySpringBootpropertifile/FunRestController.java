package UdemySpringBootpropertifile.UdemySpringBootpropertifile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    //inject properties form aplication.properites file
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //expose endpoint for "teaminfo"

    @GetMapping("/teaminfo")
    public String getTeamInfo(){

        return "Coach name:" + coachName + " Team Name: " + teamName;

    }







    //expose a "/" that returns a "Helloo World"
    @GetMapping("/")
    public String sayHello(){

        return "Hellow world! Time server is " + LocalDateTime.now();

    }

    //expose a new endpoint foe "workout"

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "run a hard 5k";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "today is your lucky day";
    }

    @GetMapping("/gica")
    public String getDaily(){
        return "today is your lucky day";
    }

    @GetMapping("/xx")
    public String getXXX(){
        return "bau bau";
    }


}
