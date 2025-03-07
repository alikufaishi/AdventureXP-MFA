package com.example.adventurexp.service;

import com.example.adventurexp.model.Booking;
import com.example.adventurexp.repositories.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepo bookingRepo;

    public List<Booking> findAll(){
        return bookingRepo.findAll();
    }
}
