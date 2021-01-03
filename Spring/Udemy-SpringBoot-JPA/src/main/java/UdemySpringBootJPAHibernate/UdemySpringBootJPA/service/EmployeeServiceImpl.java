package UdemySpringBootJPAHibernate.UdemySpringBootJPA.service;

import UdemySpringBootJPAHibernate.UdemySpringBootJPA.dao.EmployeeDAO;
import UdemySpringBootJPAHibernate.UdemySpringBootJPA.dao.EmployeeRepository;
import UdemySpringBootJPAHibernate.UdemySpringBootJPA.entiy.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        return employeeRepository.findAll();
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
