package thymeleaf.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thymeleaf.demo.dao.EmployeeRepository;
import thymeleaf.demo.entity.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


  //  private EmployeeDAO employeeDAO;

    private EmployeeRepository employeeRepository;

//    @Autowired
//    public EmployeeServiceImpl(@Qualifier("employeeJPADAOImpl") EmployeeDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
//    }

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int id) {

        return employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Didn't find id with id: " + id));
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {

        employeeRepository.deleteById(id);
    }

//    @Override
//    @Transactional
//    public List<Employee> findAll() {
//        return employeeDAO.findAll();
//    }
//
//    @Override
//    @Transactional
//    public Employee findById(int id) {
//        return employeeDAO.findById(id);
//    }
//
//    @Override
//    @Transactional
//    public void save(Employee employee) {
//        employeeDAO.save(employee);
//    }
//
//    @Override
//    @Transactional
//    public void deleteById(int id) {
//        employeeDAO.deleteById(id);
//    }
}
