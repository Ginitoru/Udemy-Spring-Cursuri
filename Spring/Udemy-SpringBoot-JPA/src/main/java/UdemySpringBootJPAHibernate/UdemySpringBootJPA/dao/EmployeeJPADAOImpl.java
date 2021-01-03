package UdemySpringBootJPAHibernate.UdemySpringBootJPA.dao;

import UdemySpringBootJPAHibernate.UdemySpringBootJPA.entiy.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeJPADAOImpl implements EmployeeDAO{

    private final EntityManager entityManager;

    @Autowired
    public EmployeeJPADAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        String jpql = "SELECT e FROM Employee e";

        return entityManager.createQuery(jpql, Employee.class)
                            .getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {

      Employee dbEmlpyee =   entityManager.merge(employee);

      employee.setId(dbEmlpyee.getId());

    }

    @Override
    public void deleteById(int id) {
        String jpql = "DELETE FROM Employee e WHERE e.id =: id";

        entityManager.createQuery(jpql)
                    .setParameter("id", id)
                    .executeUpdate();
    }
}

