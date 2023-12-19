package com.example.legaltrackerapi.services;

import com.example.legaltrackerapi.entities.TrackerModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TrackerService {

    TrackerModel createTracker(TrackerModel trackerModel);
    List<TrackerModel> viewAllCases();

}
