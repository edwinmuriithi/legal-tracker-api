package com.example.legaltrackerapi.services.Implementation;

import com.example.legaltrackerapi.entities.TrackerModel;
import com.example.legaltrackerapi.repositories.TrackerRepository;
import com.example.legaltrackerapi.services.TrackerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TrackerServiceImplementation implements TrackerService {

    @Autowired
    private TrackerRepository trackerRepository;

    public TrackerServiceImplementation(TrackerRepository trackerRepository) {
        this.trackerRepository = trackerRepository;
    }

    @Override
    public TrackerModel createTracker(TrackerModel trackerModel) {
        return null;
    }

    @Override
    public List<TrackerModel> viewAllCases() {
        return trackerRepository.findAll();
    }
}
