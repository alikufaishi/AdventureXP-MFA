package com.example.adventurexp.repositories;

import com.example.adventurexp.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Integer> {

}
