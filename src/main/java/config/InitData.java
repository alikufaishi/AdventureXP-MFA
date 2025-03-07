package config;

import com.example.adventurexp.model.Activity;
import com.example.adventurexp.model.Booking;
import com.example.adventurexp.repositories.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {
    @Autowired
    BookingRepo bookingRepo;

    @Override
    public void run(String... args) throws Exception {
        Booking booking1 = new Booking();
        booking1.setTime(LocalTime.now());
        booking1.setDate(LocalDate.of(2025,3,7));
        booking1.setDuration(LocalTime.of(1,30));
        booking1.setParticipants(15);
        booking1.setSodas(30);
        booking1.setSweet_Grams(0);
        booking1.setTshirts(5);

        //booking1.setActivity(new Activity());
        //booking1.setCustomer("");
        bookingRepo.save(booking1);
    }
}
