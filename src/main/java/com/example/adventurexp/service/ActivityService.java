package com.example.adventurexp.service;

import com.example.adventurexp.model.Activity;
import com.example.adventurexp.repositories.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepo activityRepo;

    public List<Activity> findAll() {
        return activityRepo.findAll(); // Henter alle aktiviteter fra databasen
    }

    public Activity updateActivity(int id, Activity updatedActivity) {
        return activityRepo.findById(id).map(existingActivity -> {
            if (updatedActivity.getTitle() != null) {
                existingActivity.setTitle(updatedActivity.getTitle()); // Opdaterer kun hvis `title` er sendt
            }
            return activityRepo.save(existingActivity);
        }).orElseThrow(() -> new IllegalArgumentException("Aktivitet ikke fundet"));
    }

    public Activity saveActivity(Activity activity) {
        return activityRepo.save(activity);
    }
}
