package com.example.adventurexp.repositories;

import com.example.adventurexp.model.Booking;
import com.example.adventurexp.model.SalesItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesItemRepo extends JpaRepository<SalesItem, Integer> {

    List<SalesItem> findByType(String type);

}
