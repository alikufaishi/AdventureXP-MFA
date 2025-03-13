package com.example.adventurexp.controller;

import com.example.adventurexp.model.Activity;
import com.example.adventurexp.model.Booking;
import com.example.adventurexp.repositories.ActivityRepo;
import com.example.adventurexp.repositories.BookingRepo;
import com.example.adventurexp.service.ActivityService;
import com.example.adventurexp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


// CrossOrigin definerer hvor requesten må komme fra
@RestController
@CrossOrigin(origins = "https://white-cliff-01dae2510.6.azurestaticapps.net")
public class HomeController {

    @Autowired
    BookingService bookingService;

    @Autowired
    private ActivityService activityService;

    // Postmapping fortæller at når en frontend server sender request til /activities, så kører denne kode
    @PostMapping("/activities")
    public Activity createActivity(@RequestBody Activity activity) {
        return activityService.saveActivity(activity);
    }

    @GetMapping("/activities")
    public List<Activity> getAllActivities() {
        return activityService.findAll(); // Henter alle aktiviteter fra databasen
    }
    @PostMapping("/create-booking")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }
    @PutMapping("/bookings/{id}")
    public Booking updateBooking(@PathVariable int id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }
    @DeleteMapping("/bookings/{id}")
    public void deleteBooking(@PathVariable int id) {
        bookingService.deleteBooking(id);
    }



}

