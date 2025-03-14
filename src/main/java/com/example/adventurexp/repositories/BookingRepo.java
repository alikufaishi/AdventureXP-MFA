package com.example.adventurexp.repositories;

import com.example.adventurexp.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
    List<Booking> findByDate(LocalDate date);

    List<Booking> findAllByOrderByDateAscTimeAsc();

    // Find bookinger for en bestemt aktivitet
    List<Booking> findByActivityId(int activityId);

}
