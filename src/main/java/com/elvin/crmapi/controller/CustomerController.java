package com.elvin.crmapi.controller;

import java.util.List;

import com.elvin.crmapi.model.Customer;
import com.elvin.crmapi.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService; 

    @GetMapping
    public List<Customer> show(){

        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer show(@PathVariable("id") int id){
        
        return customerService.getById(id);
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer) {

        
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public Customer save(@RequestBody Customer newCustomerData, @PathVariable("id")int id){

        Customer storedCustomerData = customerService.getById(id);

        storedCustomerData.setName(newCustomerData.getName());
        storedCustomerData.setSurname(newCustomerData.getSurname());
        storedCustomerData.setEmail(newCustomerData.getEmail());
        storedCustomerData.setBirthdate(newCustomerData.getBirthdate());


        return customerService.save(storedCustomerData);
    }

    

}
