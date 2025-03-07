package com.example.adventurexp.repositories;

import com.example.adventurexp.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepo extends JpaRepository<Activity, Integer> {
}
