package com.example.legaltrackerapi.services;

import com.example.legaltrackerapi.entities.TrackerModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface TrackerService {

    TrackerModel createTracker(TrackerModel trackerModel);
    List<TrackerModel> viewAllCases();
    Optional<TrackerModel> findByCourtFileNo(String courtFileNo);
    TrackerModel updateTrackerByCourtFile(TrackerModel updatedTrackerModel , String courtFile);
    Optional<TrackerModel> findBySpecies(String species);
    void deleteTracker(String courtFile);

}
