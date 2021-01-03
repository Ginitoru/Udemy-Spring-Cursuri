package com.luv2code.springdemo.mvc.controllers;

import com.luv2code.springdemo.mvc.model.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

 @InitBinder                                                                                //face trim la white space inainte si dupa stringul introdus
 public void initBinder (WebDataBinder dataBinder){                                         //face la fiecare web request
     StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

     dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

 }


@RequestMapping("/showForm")
 public String showForm(Model theModel){
    //se creeaza obiectul de customer si cand se introduc valori in campuri acestea sunt setate pe obiect si api introdus obiectul in model
     theModel.addAttribute("customer", new Customer());

     return "customer-form";
 }

@RequestMapping("/processForm")
 public String processForm(
         @Valid @ModelAttribute("customer") Customer theCustomer,
         BindingResult theBindingResult){


         System.out.println("Last name: " + theCustomer.getLastName() + " |");

         System.out.println("Binding result: "  + theBindingResult );
         System.out.println("\n\n\n\n");

         if(theBindingResult.hasErrors()) {
             return "customer-form";
         }

         return "customer-confirmation";
 }




}
