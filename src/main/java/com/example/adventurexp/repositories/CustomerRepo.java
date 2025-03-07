package com.example.adventurexp.repositories;

import com.example.adventurexp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
