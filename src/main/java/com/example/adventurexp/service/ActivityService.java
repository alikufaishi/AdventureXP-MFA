package com.example.adventurexp.service;

import com.example.adventurexp.model.Activity;
import com.example.adventurexp.repositories.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepo activityRepo;

    public Activity saveActivity(Activity activity) {
        return activityRepo.save(activity);
    }
}
