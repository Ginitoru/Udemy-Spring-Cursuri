package thymeleaf.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thymeleaf.demo.entity.Employee;
import thymeleaf.demo.service.EmployeeService;




@Controller
@RequestMapping("/employees")
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){

        model.addAttribute("employees",employeeService.findAll());

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Employee theEmployee = new Employee();

        model.addAttribute("employee", theEmployee);

        return "employees/employee-form";

    }

    @GetMapping("/showFormForUpdate")
    public String showFomFormUpdate(@RequestParam("employeeId") int theId, Model model){

        Employee employee = employeeService.findById(theId);

        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        employeeService.save(employee);

        return "redirect:/employees/list";

    }


    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){

        employeeService.deleteById(theId);


        return "redirect:/employees/list";
    }




}
