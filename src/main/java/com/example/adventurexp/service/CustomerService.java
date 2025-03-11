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
}