package com.elvin.crmapi.service;

import java.util.List;

import com.elvin.crmapi.model.Customer;
import com.elvin.crmapi.respository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll() {
      
        return customerRepository.findAll();
    }

    public Customer getById(int id) {
       
        return customerRepository.findById(id).orElse(new Customer());
        
    }
}
