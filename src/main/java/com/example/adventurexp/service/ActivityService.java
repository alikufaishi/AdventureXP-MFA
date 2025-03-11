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

    public Activity saveActivity(Activity activity) {
        return activityRepo.save(activity);
    }

    public List<Activity> findAll() {
        return activityRepo.findAll(); // Henter alle aktiviteter fra databasen
    }
}
