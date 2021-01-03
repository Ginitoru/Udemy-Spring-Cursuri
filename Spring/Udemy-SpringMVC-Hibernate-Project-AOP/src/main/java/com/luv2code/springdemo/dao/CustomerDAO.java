package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    Customer getCustomerId(int theId);

    void updateCustomer(Customer customer);

    void deleteCustomer(int theId);


    List<Customer> searchCustomers(String theSearchName);
}
