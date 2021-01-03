package UdemySpringBootJPAHibernate.UdemySpringBootJPA.service;

import UdemySpringBootJPAHibernate.UdemySpringBootJPA.entiy.Employee;

import java.util.List;


public interface EmployeeService {



    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);


}
