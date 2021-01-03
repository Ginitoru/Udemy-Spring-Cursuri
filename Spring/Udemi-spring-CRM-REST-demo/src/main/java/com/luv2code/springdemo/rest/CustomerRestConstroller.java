package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.error.CustomerNotFoundException;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController()
@RequestMapping("/api")
public class CustomerRestConstroller {


    //autowire the CustomerService
    @Autowired
    private CustomerService customerService;

    //add mapping for GET /customers
    @GetMapping("/customers")
    public List<Customer> getList(){

        return customerService.getCustomers();

    }

    @GetMapping("/customers/{customerId}") //retrieve 1 customer
    public Customer getCustomer(@PathVariable int customerId){

        Customer customer =  customerService.getCustomer(customerId); //daca nu gaseste in baza de date returneaza null
                                                        //la null Jackson retunreaza un JSON blank

        if(customer == null){
            throw new CustomerNotFoundException("Customer id not found " + customerId );
        }

        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer){

         customerService.saveCustomer(theCustomer);

         return theCustomer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){

        customerService.updateCustomer(customer);

        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){

        Customer customer = customerService.getCustomer(customerId);

        if(customer == null){
            throw new CustomerNotFoundException("Client not found id: " + customerId);
        }
        customerService.deleteCustomer(customerId);
        return "Deleted id " + customerId;
    }





}
