package UdemySpringBootJPAHibernate.UdemySpringBootJPA.dao;

import UdemySpringBootJPAHibernate.UdemySpringBootJPA.entiy.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {


    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        Session curentSession = entityManager.unwrap(Session.class);

        String jpql = "SELECT e FROM Employee e";

        return curentSession.createQuery(jpql, Employee.class)
                            .getResultList();

    }

    @Override
    public Employee findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
       return  currentSession.find(Employee.class,id);
    }

    @Override
    public void save(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQery = currentSession.createQuery("DELETE FROM Employee e WHERE e.id = :id")
                                        .setParameter("id", id);

        int x  = theQery.executeUpdate();
        System.out.println("Delete: " + x);

    }
}
