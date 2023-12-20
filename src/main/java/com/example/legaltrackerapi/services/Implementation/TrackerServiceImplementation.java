package com.example.legaltrackerapi.services.Implementation;

import com.example.legaltrackerapi.entities.TrackerModel;
import com.example.legaltrackerapi.repositories.TrackerRepository;
import com.example.legaltrackerapi.services.TrackerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        try {
            // Populate the TrackerModel with the necessary data
            trackerModel.setCourt_file_no(trackerModel.getCourt_file_no());
            trackerModel.setName_of_accused(trackerModel.getName_of_accused());
            trackerModel.setNationality(trackerModel.getNationality());
            trackerModel.setGender(trackerModel.getGender());
            trackerModel.setId_passport_no(trackerModel.getId_passport_no());
            trackerModel.setMagistrate(trackerModel.getMagistrate());
            trackerModel.setDate_of_plea(trackerModel.getDate_of_plea());
            trackerModel.setPlea(trackerModel.getPlea());
            trackerModel.setBond_terms(trackerModel.getBond_terms());
            trackerModel.setBond_surety_name(trackerModel.getBond_surety_name());
            trackerModel.setSurety_details(trackerModel.getSurety_details());
            trackerModel.setCharge1(trackerModel.getCharge1());
            trackerModel.setCharge2(trackerModel.getCharge2());
            trackerModel.setCharge3(trackerModel.getCharge3());
            trackerModel.setCharge4(trackerModel.getCharge4());
            trackerModel.setCharge5(trackerModel.getCharge5());
            trackerModel.setSpecies(trackerModel.getSpecies());
            trackerModel.setExhibit(trackerModel.getExhibit());
            trackerModel.setWeight(trackerModel.getWeight());
            trackerModel.setJudgement_date(trackerModel.getJudgement_date());
            trackerModel.setJudgement_outcome(trackerModel.getJudgement_outcome());
            trackerModel.setSentencing(trackerModel.getSentencing());
            trackerModel.setCase_status(trackerModel.getCase_status());
            trackerModel.setLocation_of_arrest(trackerModel.getLocation_of_arrest());
            trackerModel.setArresting_authority(trackerModel.getArresting_authority());
            trackerModel.setProsecutor(trackerModel.getProsecutor());


            // Save the populated tracker model
            TrackerModel savedTracker = trackerRepository.save(trackerModel);
            log.info("Tracker created successfully with Court File Number: {}", savedTracker.getCourt_file_no());
            return savedTracker;
        } catch (Exception e) {
            log.error("Error creating tracker: {}", e.getMessage());
            // You may handle exceptions based on your application requirements
            throw new RuntimeException("Error creating tracker", e);
        }
    }

    @Override
    public List<TrackerModel> viewAllCases() {
        return trackerRepository.findAll();
    }

    @Override
    public Optional<TrackerModel> findByCourtFile(String courtFile) {
        return trackerRepository.findByCourtFile(courtFile);
    }

    @Override
    public TrackerModel updateTrackerByCourtFile(TrackerModel updatedTrackerModel, String courtFile) {
        try {
            // Retrieve the existing tracker from the database
            Optional<TrackerModel> existingTrackerOptional = trackerRepository.findByCourtFile(courtFile);

            if (existingTrackerOptional.isPresent()) {
                TrackerModel existingTracker = existingTrackerOptional.get();

                // Update fields with the new data
                existingTracker.setCourt_file_no(existingTracker.getCourt_file_no());
                existingTracker.setName_of_accused(existingTracker.getName_of_accused());
                existingTracker.setNationality(existingTracker.getNationality());
                existingTracker.setGender(existingTracker.getGender());
                existingTracker.setId_passport_no(existingTracker.getId_passport_no());
                existingTracker.setMagistrate(existingTracker.getMagistrate());
                existingTracker.setDate_of_plea(existingTracker.getDate_of_plea());
                existingTracker.setPlea(existingTracker.getPlea());
                existingTracker.setBond_terms(existingTracker.getBond_terms());
                existingTracker.setBond_surety_name(existingTracker.getBond_surety_name());
                existingTracker.setSurety_details(existingTracker.getSurety_details());
                existingTracker.setCharge1(existingTracker.getCharge1());
                existingTracker.setCharge2(existingTracker.getCharge2());
                existingTracker.setCharge3(existingTracker.getCharge3());
                existingTracker.setCharge4(existingTracker.getCharge4());
                existingTracker.setCharge5(existingTracker.getCharge5());
                existingTracker.setSpecies(existingTracker.getSpecies());
                existingTracker.setExhibit(existingTracker.getExhibit());
                existingTracker.setWeight(existingTracker.getWeight());
                existingTracker.setJudgement_date(existingTracker.getJudgement_date());
                existingTracker.setJudgement_outcome(existingTracker.getJudgement_outcome());
                existingTracker.setSentencing(existingTracker.getSentencing());
                existingTracker.setCase_status(existingTracker.getCase_status());
                existingTracker.setLocation_of_arrest(existingTracker.getLocation_of_arrest());
                existingTracker.setArresting_authority(existingTracker.getArresting_authority());
                existingTracker.setProsecutor(existingTracker.getProsecutor());


                // Save the updated tracker model
                TrackerModel updatedTracker = trackerRepository.save(existingTracker);
                log.info("Tracker updated successfully with Court File Number: {}", updatedTracker.getCourt_file_no());
                return updatedTracker;
            } else {
                log.error("Tracker not found with Court File Number: {}", courtFile);
                throw new RuntimeException("Tracker not found");
            }
        } catch (Exception e) {
            log.error("Error updating tracker: {}", e.getMessage());
            // You may handle exceptions based on your application requirements
            throw new RuntimeException("Error updating tracker", e);
        }
    }

}
