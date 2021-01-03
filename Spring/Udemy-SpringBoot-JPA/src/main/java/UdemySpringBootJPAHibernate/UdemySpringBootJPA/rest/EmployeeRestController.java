package UdemySpringBootJPAHibernate.UdemySpringBootJPA.rest;

import UdemySpringBootJPAHibernate.UdemySpringBootJPA.dao.EmployeeDAO;
import UdemySpringBootJPAHibernate.UdemySpringBootJPA.entiy.Employee;
import UdemySpringBootJPAHibernate.UdemySpringBootJPA.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){

        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findEmployee(@PathVariable int employeeId){

       Employee employee = employeeService.findById(employeeId);

       if(employee ==null){
           throw new RuntimeException("Employee not found: " + employeeId);
       }

       return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee){

        employee.setId(0);

        employeeService.save(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){

        employeeService.save(employee);

        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String delete(@PathVariable  int employeeId){

        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee id " + employeeId + " does not exist");

        }

        employeeService.deleteById(employeeId);

        return "Employee " + employeeId + " deleted";

    }




}
