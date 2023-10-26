package com.demo.spring_mvc_jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring_mvc_jpa.model.Customer;
import com.demo.spring_mvc_jpa.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
    public void save(Customer customer) {
    	customerRepository.save(customer);
    }
     
    public List<Customer> listAll() {
        return (List<Customer>) customerRepository.findAll();
    }
     
    public Customer get(Long id) {
        return customerRepository.findById(id).get();
    }
     
    public void delete(Long id) {
    	customerRepository.deleteById(id);
    }
    
    public List<Customer> search(String keyword) {
        return customerRepository.search(keyword);
    }
}
