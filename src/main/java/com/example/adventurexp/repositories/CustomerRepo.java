package com.example.adventurexp.repositories;

import com.example.adventurexp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByPhone(String phone);
}
