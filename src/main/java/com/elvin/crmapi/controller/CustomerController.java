package com.elvin.crmapi.controller;

import java.util.List;

import com.elvin.crmapi.model.Customer;
import com.elvin.crmapi.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService; 

    @GetMapping
    public ResponseEntity<List<Customer>> listCustomers(){

        return ResponseEntity.ok(customerService.getAll()); 
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Customer> showCustomer(@PathVariable("id") int id){

        Customer customer = customerService.getById(id);

        if(customer.getId() <= 0) {

            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(customer); 
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

        customerService.save(customer);
        
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> editCustomer(@RequestBody Customer newCustomerData, @PathVariable("id")int id){

        Customer storedCustomerData = customerService.getById(id);

        storedCustomerData.setName(newCustomerData.getName());
        storedCustomerData.setSurname(newCustomerData.getSurname());
        storedCustomerData.setEmail(newCustomerData.getEmail());
        storedCustomerData.setBirthdate(newCustomerData.getBirthdate());

        customerService.save(storedCustomerData);
        
        return ResponseEntity.ok(storedCustomerData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id")int id){

            customerService.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 
}
