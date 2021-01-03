package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
//	@Autowired
//	private SessionFactory sessionFactory;

	@PersistenceContext
	private EntityManager em;
			
	@Override
	public List<Customer> getCustomers() {

		String jpql = "SELECT c FROM Customer c ORDER BY c.lastName";

		List<Customer> customers = em.createQuery(jpql, Customer.class)
				.getResultList();
		return customers;

	}

	@Override
	public void saveCustomer(Customer theCustomer) {

//		// get current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
//
//		// save/upate the customer ... finally LOL
//		currentSession.saveOrUpdate(theCustomer);

		em.persist(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {

		return em.find(Customer.class, theId);

	}

	@Override
	public void deleteCustomer(int theId) {


		String jpql = "DELETE FROM Customer c WHERE c.id =: id";

		int x = em.createQuery(jpql)
						.setParameter("id", theId)
						.executeUpdate();

		System.out.println(x);
	}

	@Override
	public void updateCustomer(Customer customer) {

		String jpql = "UPDATE Customer c SET c.firstName = :firstName, c.lastName =:lastName, c.email =:email WHERE c.id =:id";

		int x = em.createQuery(jpql)
				.setParameter("firstName", customer.getFirstName())
				.setParameter("lastName", customer.getLastName())
				.setParameter("email", customer.getEmail())
				.setParameter("id", customer.getId())
				.executeUpdate();
		System.out.println("Update: " + x);

	}

}











