package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.dao.CustomerDao;
import com.customer.model.Customer;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
    
    @Autowired
    private CustomerDao customerDao;

    public String addCustomer(Customer customer) {
        customerDao.save(customer);
        return "Customer added successfully!";
    }

    public List<Customer> getAllCustomer() {
        return customerDao.findAll();
    }

    public Customer updateCustomer(String email, Customer updatedCustomer) {
        Customer existingCustomer = customerDao.findByEmail(email);
        if (existingCustomer != null) {
            existingCustomer.setCname(updatedCustomer.getCname());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            customerDao.save(existingCustomer);
            return existingCustomer;
        }
        return null; // or throw an exception if preferred
    }

    public boolean deleteCustomer(Integer cid) {
        if (customerDao.existsById(cid)) {
            customerDao.deleteById(cid);
            return true;
        }
        return false;
    }
}