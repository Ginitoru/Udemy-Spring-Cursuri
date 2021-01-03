package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Customer> getCustomers() {

        //slecteaza Customer c si ii ordoneaza dupa (ORDER BY) lastName
        String jpql = "SELECT c FROM Customer c ORDER BY c.lastName";

        List<Customer> customers = em.createQuery(jpql, Customer.class)
                                  .getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        em.persist(theCustomer);

    }

    @Override
    public Customer getCustomerId(int theId) {
        Customer customer = em.find(Customer.class, theId);
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        String jpql = "UPDATE Customer c SET c.firstName = :firstName, c.lastName =:lastName, c.email =:email WHERE c.id =:id ";

        int x = em.createQuery(jpql)
                .setParameter("firstName", customer.getFirstName())
                .setParameter("lastName", customer.getLastName())
                .setParameter("email", customer.getEmail())
                .setParameter("id", customer.getId())
                .executeUpdate();
        System.out.println("Update: " + x);
    }

    @Override
    public void deleteCustomer(int theId) {

        String jpql = "DELETE FROM Customer c WHERE c.id = :customerId";

        int x = em.createQuery(jpql)
                .setParameter("customerId", theId)
                .executeUpdate();

        System.out.println( "Delete: " + x);
    }


    //face search si imi arata Customerii care contin anumite litere
    @Override
    public List<Customer> searchCustomers(String theSearchName) {
        String jpql = "SELECT c FROM Customer c WHERE c.firstName LIKE :name OR c.lastName LIKE :name";

        List<Customer> customers = em.createQuery(jpql, Customer.class)
                                    .setParameter("name", "%" + theSearchName + "%")
                                    .getResultList();

        return customers;
    }


}
