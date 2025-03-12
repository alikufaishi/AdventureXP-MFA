package com.example.adventurexp.repositories;

import com.example.adventurexp.model.SalesItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesItemRepo extends JpaRepository<SalesItem, Integer> {

}
