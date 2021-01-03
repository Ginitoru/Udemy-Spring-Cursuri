package UdemySpringBootJPAHibernate.UdemySpringBootJPA.dao;

import UdemySpringBootJPAHibernate.UdemySpringBootJPA.entiy.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
