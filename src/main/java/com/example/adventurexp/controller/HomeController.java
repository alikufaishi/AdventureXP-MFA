package com.example.adventurexp.controller;

import com.example.adventurexp.model.Activity;
import com.example.adventurexp.model.Booking;
import com.example.adventurexp.repositories.BookingRepo;
import com.example.adventurexp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@RestController
public class HomeController {

    @Autowired
    BookingService bookingService;

    @Autowired
    BookingRepo bookingRepo;

    @GetMapping("index")
    public List<Booking> getAllBookings() {
        Activity activity1 = new Activity();

        Booking booking1 = new Booking();
        booking1.setTime(LocalTime.now());
        booking1.setDate(LocalDate.of(2025,3,7));
        booking1.setDuration(LocalTime.of(1,30));
        booking1.setParticipants(15);
        booking1.setSodas(20);
        booking1.setSweet_Grams(0);
        booking1.setTshirts(5);

        booking1.setActivity(new Activity(1,"Bowling", 12, 145, "hat", 123));
        //booking1.setCustomer("");
        bookingRepo.save(booking1);
        return bookingService.findAll();
    }
}
