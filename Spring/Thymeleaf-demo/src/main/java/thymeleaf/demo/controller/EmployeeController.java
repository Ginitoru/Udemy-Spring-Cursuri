package thymeleaf.demo.controller;

import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import thymeleaf.demo.model.Employee;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


    private List<Employee> theEmployees = new ArrayList<>();

    @PostConstruct
    public void loadData(){

        Employee emp1 = new Employee("Leslie", "Andrews", "fsdf@lovetocode.com");
        Employee emp2 = new Employee("vasile", "gica", "xx@hhhhh.com");
        Employee emp3 = new Employee("fane", "ionel", "xxx@lllll.com");

        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);

    }

    @GetMapping("/list")
    public String listEmployees(Model model){

        model.addAttribute("employees",theEmployees);

        return "list-employees";
    }




}
