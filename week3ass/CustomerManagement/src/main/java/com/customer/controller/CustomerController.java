
package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.customer.model.Customer;
import com.customer.service.CustomerService;

@RestController
@RequestMapping("/customers") // Base path for all endpoints
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomerDetails() {
        List<Customer> customerList = customerService.getAllCustomer();
        if (customerList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customerList);
    }

    @PostMapping
    public ResponseEntity<String> addCustomerDetails(@RequestBody Customer customer) {
        String response = customerService.addCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{email}")
    public ResponseEntity<Customer> updateCustomerDetails(@PathVariable("email") String email, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(email, customer);
        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{cid}")
    public ResponseEntity<String> deleteCustomerDetails(@PathVariable("cid") Integer cid) {
        boolean isDeleted = customerService.deleteCustomer(cid);
        if (isDeleted) {
            return ResponseEntity.ok("Customer deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
