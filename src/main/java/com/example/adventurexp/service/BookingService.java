package com.example.adventurexp.service;

import com.example.adventurexp.model.Booking;
import com.example.adventurexp.model.Customer;
import com.example.adventurexp.repositories.BookingRepo;
import com.example.adventurexp.repositories.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    BookingRepo bookingRepo;
    @Autowired
    private CustomerRepo customerRepo;

    public List<Booking> findAll(){
        return bookingRepo.findAllByOrderByDateDesc();
    }
    public Booking createBooking(Booking booking) {
        // Tjek om kunden allerede findes i databasen via email
        Optional<Customer> existingCustomer = customerRepo.findByPhone(booking.getCustomer().getPhone());

        Customer customer;
        if (existingCustomer.isPresent()) {
            // Hvis kunden findes, genbrug den
            customer = existingCustomer.get();
        } else {
            // Hvis kunden ikke findes, opret en ny i databasen
            customer = customerRepo.save(booking.getCustomer());
        }

        // Sæt den gemte eller eksisterende kunde til bookingen
        booking.setCustomer(customer);

        // Gem bookingen med den tilknyttede kunde
        return bookingRepo.save(booking);
    }
    public Booking updateBooking(int id, Booking updatedBooking) {
        if (bookingRepo.existsById(id)) {
            updatedBooking.setId(id); // Sørger for at ID'et ikke ændres
            return bookingRepo.save(updatedBooking);
        } else {
            throw new IllegalArgumentException("Booking ikke fundet");
        }
    }
    public void deleteBooking(int id) {
        bookingRepo.deleteById(id);
    }


}
