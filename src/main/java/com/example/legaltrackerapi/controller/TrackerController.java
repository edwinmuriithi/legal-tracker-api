package com.example.legaltrackerapi.controller;

import com.example.legaltrackerapi.entities.TrackerModel;
import com.example.legaltrackerapi.services.TrackerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/tracker")
public class TrackerController {
    private final TrackerService trackerService;

    public TrackerController(TrackerService trackerService) {
        this.trackerService = trackerService;
    }


    @GetMapping
    public ResponseEntity<List<TrackerModel>> viewAllCases() {
        List<TrackerModel> allCases = trackerService.viewAllCases();
        return new ResponseEntity<>(allCases, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TrackerModel> createTracker(@RequestBody TrackerModel trackerModel) {
        try {
            TrackerModel savedTracker = trackerService.createTracker(trackerModel);
            return new ResponseEntity<>(savedTracker, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{courtFile}")
    public ResponseEntity<TrackerModel> findByCourtFile(@PathVariable String courtFile) {
        Optional<TrackerModel> tracker = trackerService.findByCourtFileNo(courtFile);
        return tracker.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
//    @PutMapping("/{courtFile}")
//    public ResponseEntity<TrackerModel> updateTracker(@PathVariable String courtFile, @RequestBody TrackerModel updatedTrackerModel) {
//        try {
//            TrackerModel updatedTracker = trackerService.updateTrackerByCourtFile(updatedTrackerModel,courtFile);
//            return new ResponseEntity<>(updatedTracker, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            // Handle the case where the tracker is not found or there is an error
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    @DeleteMapping("/{courtFile}")
//    public ResponseEntity<Void> deleteTracker(@PathVariable String courtFile) {
//        try {
//            trackerService.deleteTracker(courtFile);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (RuntimeException e) {
//            // Handle the case where the tracker is not found or there is an error
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

}
