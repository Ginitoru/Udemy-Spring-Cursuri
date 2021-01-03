package com.luv2code.springdemo.controller;


import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomers(Model model){

        List<Customer> theCustomers = customerService.getCustomers();


        model.addAttribute("customers", theCustomers);

        return "list-customers";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Customer theCustomer = new Customer();

        model.addAttribute("customer", theCustomer);


        return "customer-form";
    }


    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

        customerService.saveCustomer(theCustomer);



        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateCustomer(@RequestParam("customerId") int theId, Model model){ //vezi list-customer.jps pt customerId

        Customer theCustomer = customerService.getCustomer(theId);

        model.addAttribute("customer", theCustomer);

        return "customer-form";

    }


    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){

        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                  Model theModel) {

        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }





}
