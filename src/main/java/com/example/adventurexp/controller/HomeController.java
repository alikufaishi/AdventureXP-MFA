package com.example.adventurexp.controller;

import com.example.adventurexp.model.Activity;
import com.example.adventurexp.model.Booking;
import com.example.adventurexp.model.Customer;
import com.example.adventurexp.model.SalesItem;
import com.example.adventurexp.repositories.ActivityRepo;
import com.example.adventurexp.repositories.BookingRepo;
import com.example.adventurexp.service.ActivityService;
import com.example.adventurexp.service.BookingService;
import com.example.adventurexp.service.CustomerService;
import com.example.adventurexp.service.SalesItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


// CrossOrigin definerer hvor requesten må komme fra
@RestController
@CrossOrigin(origins = "https://white-cliff-01dae2510.6.azurestaticapps.net")
public class HomeController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/activities")
    public List<Activity> getAllActivities() {
        return activityService.findAll(); // Henter alle aktiviteter fra databasen
    }

    @Autowired
    BookingService bookingService;

    @Autowired
    private SalesItemService salesItemService;

    @Autowired
    private CustomerService customerService;

    // Postmapping fortæller at når en frontend server sender request til /activities, så kører denne kode
    @PostMapping("/activities")
    public Activity createActivity(@RequestBody Activity activity) {
        return activityService.saveActivity(activity);
    }


    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }
    @PutMapping("/activities/{id}")
    public Activity updateActivity(@PathVariable int id, @RequestBody Activity activity) {
        return activityService.updateActivity(id, activity);
    }

    @GetMapping("/salesitems")
    public List<SalesItem> getAllSalesItems() {
        return salesItemService.findAll(); // Henter alle produkter fra databasen
    }

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.findAll();
    }

    @PostMapping("/salesitems")
    public SalesItem createSalesItem(@RequestBody SalesItem salesItem) {
        return salesItemService.saveSalesItem(salesItem); // Gemmer et produkt i butikken
    }

    @PostMapping("/create-booking")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }
    @PutMapping("/bookings/{id}")
    public Booking updateBooking(@PathVariable int id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }
    @PutMapping("/bookings/{id}/instructor")
    public Booking updateInstructor(@PathVariable int id, @RequestBody String instructor) {
        return bookingService.updateInstructor(id, instructor);
    }
    @DeleteMapping("/bookings/{id}")
    public void deleteBooking(@PathVariable int id) {
        bookingService.deleteBooking(id);
    }



}

