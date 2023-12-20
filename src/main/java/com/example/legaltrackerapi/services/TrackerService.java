package com.example.legaltrackerapi.services;

import com.example.legaltrackerapi.entities.TrackerModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface TrackerService {

    TrackerModel createTracker(TrackerModel trackerModel);
    List<TrackerModel> viewAllCases();
    Optional<TrackerModel> findByCourtFile(String courtFile);
    TrackerModel updateTrackerByCourtFile(TrackerModel updatedTrackerModel , String courtFile);

}
