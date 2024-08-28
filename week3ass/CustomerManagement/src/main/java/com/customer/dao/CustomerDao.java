package com.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

    Customer findByEmail(String email);
}