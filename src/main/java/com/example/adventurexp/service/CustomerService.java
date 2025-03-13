package com.example.adventurexp.service;

import com.example.adventurexp.model.Customer;
import com.example.adventurexp.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Optional<Customer> findCustomerByPhone(String phone) {
        return customerRepo.findByPhone(phone);
    }

    public Customer updateCustomer(int id, Customer updatedCustomer) {
        return customerRepo.findById(id).map(existingCustomer -> {
            if (updatedCustomer.getName() != null) {
                existingCustomer.setName(updatedCustomer.getName());
            }
            if (updatedCustomer.getPhone() != null) {
                existingCustomer.setPhone(updatedCustomer.getPhone());
            }
            return customerRepo.save(existingCustomer);
        }).orElseThrow(() -> new IllegalArgumentException("Kunde ikke fundet"));
    }
}