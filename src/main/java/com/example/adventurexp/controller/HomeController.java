package com.example.adventurexp.controller;

import com.example.adventurexp.model.Activity;
import com.example.adventurexp.model.Booking;
import com.example.adventurexp.repositories.ActivityRepo;
import com.example.adventurexp.repositories.BookingRepo;
import com.example.adventurexp.service.ActivityService;
import com.example.adventurexp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


// CrossOrigin definerer hvor requesten må komme fra
@RestController
@CrossOrigin(origins = "https://white-cliff-01dae2510.6.azurestaticapps.net/")
public class HomeController {

    @Autowired
    BookingService bookingService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    ActivityRepo activityRepo;

    // Postmapping fortæller at når en frontend server sender request til /activities, så kører denne kode
    @PostMapping("/activities")
    public Activity createActivity(@RequestBody Activity activity) {
        return activityService.saveActivity(activity);
    }

    @GetMapping("/activities")
    public List<Activity> getAllActivities() {
        return activityService.findAll(); // Henter alle aktiviteter fra databasen
    }

    // Bruges ikke til noget
    @GetMapping("index")
    public List<Booking> getAllBookings() {

        /*
        // Her opretter vi en række i Activity-tabellen
        Activity activity1 = new Activity("Bowling",12, 145, "hat", 123);
        activityRepo.save(activity1);


        Booking booking1 = new Booking();
        booking1.setTime(LocalTime.now());
        booking1.setDate(LocalDate.of(2025,3,7));
        booking1.setDuration(LocalTime.of(1,30));
        booking1.setParticipants(15);
        booking1.setSodas(20);
        booking1.setSweet_Grams(0);
        booking1.setTshirts(5);

        // Her finder vi en eksisterende række i activity-tabellen og laver en foreign key til den
        booking1.setActivity(new Activity("Bowling",12, 145, "hat", 123));
        //booking1.setCustomer("");
        bookingRepo.save(booking1);
        */
        return bookingService.findAll();
    }
}
