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

    private final TrackerRepository trackerRepository;

    public TrackerServiceImplementation(TrackerRepository trackerRepository) {
        this.trackerRepository = trackerRepository;
    }

    @Override
    public TrackerModel createTracker(TrackerModel trackerModel) {
        try {
            // Populate the TrackerModel with the necessary data
            trackerModel.setCourtFileNo(trackerModel.getCourtFileNo());
            trackerModel.setNameOfAccused(trackerModel.getNameOfAccused());
            trackerModel.setNationality(trackerModel.getNationality());
            trackerModel.setGender(trackerModel.getGender());
            trackerModel.setIdPassportNo(trackerModel.getIdPassportNo());
            trackerModel.setMagistrate(trackerModel.getMagistrate());
            trackerModel.setDateOfPlea(trackerModel.getDateOfPlea());
            trackerModel.setPlea(trackerModel.getPlea());
            trackerModel.setBondTerms(trackerModel.getBondTerms());
            trackerModel.setBondSuretyName(trackerModel.getBondSuretyName());
            trackerModel.setSuretyDetails(trackerModel.getSuretyDetails());
            trackerModel.setCharge1(trackerModel.getCharge1());
            trackerModel.setCharge2(trackerModel.getCharge2());
            trackerModel.setCharge3(trackerModel.getCharge3());
            trackerModel.setCharge4(trackerModel.getCharge4());
            trackerModel.setCharge5(trackerModel.getCharge5());
            trackerModel.setSpecies(trackerModel.getSpecies());
            trackerModel.setExhibit(trackerModel.getExhibit());
            trackerModel.setWeight(trackerModel.getWeight());
            trackerModel.setJudgementDate(trackerModel.getJudgementDate());
            trackerModel.setJudgementOutcome(trackerModel.getJudgementOutcome());
            trackerModel.setSentencing(trackerModel.getSentencing());
            trackerModel.setCaseStatus(trackerModel.getCaseStatus());
            trackerModel.setLocationOfArrest(trackerModel.getLocationOfArrest());
            trackerModel.setArrestingAuthority(trackerModel.getArrestingAuthority());
            trackerModel.setProsecutor(trackerModel.getProsecutor());


            // Save the populated tracker model
            TrackerModel savedTracker = trackerRepository.save(trackerModel);
            log.info("Tracker created successfully with Court File Number: {}", savedTracker.getCourtFileNo());
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
    public Optional<TrackerModel> findByCourtFileNo(String courtFileNo) {
        return trackerRepository.findByCourtFileNo(courtFileNo);

    }

    @Override
    public TrackerModel updateTrackerByCourtFile(TrackerModel updatedTrackerModel, String courtFile) {
        try {
            // Retrieve the existing tracker from the database
            Optional<TrackerModel> existingTrackerOptional = trackerRepository.findByCourtFileNo(courtFile);

            if (existingTrackerOptional.isPresent()) {
                TrackerModel existingTracker = existingTrackerOptional.get();

                // Update fields with the new data from updatedTrackerModel
                existingTracker.setNameOfAccused(updatedTrackerModel.getNameOfAccused());
                existingTracker.setNationality(updatedTrackerModel.getNationality());
                existingTracker.setGender(updatedTrackerModel.getGender());
                existingTracker.setIdPassportNo(updatedTrackerModel.getIdPassportNo());
                existingTracker.setMagistrate(updatedTrackerModel.getMagistrate());
                existingTracker.setDateOfPlea(updatedTrackerModel.getDateOfPlea());
                existingTracker.setPlea(updatedTrackerModel.getPlea());
                existingTracker.setBondTerms(updatedTrackerModel.getBondTerms());
                existingTracker.setBondSuretyName(updatedTrackerModel.getBondSuretyName());
                existingTracker.setSuretyDetails(updatedTrackerModel.getSuretyDetails());
                existingTracker.setCharge1(updatedTrackerModel.getCharge1());
                existingTracker.setCharge2(updatedTrackerModel.getCharge2());
                existingTracker.setCharge3(updatedTrackerModel.getCharge3());
                existingTracker.setCharge4(updatedTrackerModel.getCharge4());
                existingTracker.setCharge5(updatedTrackerModel.getCharge5());
                existingTracker.setSpecies(updatedTrackerModel.getSpecies());
                existingTracker.setExhibit(updatedTrackerModel.getExhibit());
                existingTracker.setWeight(updatedTrackerModel.getWeight());
                existingTracker.setJudgementDate(updatedTrackerModel.getJudgementDate());
                existingTracker.setJudgementOutcome(updatedTrackerModel.getJudgementOutcome());
                existingTracker.setSentencing(updatedTrackerModel.getSentencing());
                existingTracker.setCaseStatus(updatedTrackerModel.getCaseStatus());
                existingTracker.setLocationOfArrest(updatedTrackerModel.getLocationOfArrest());
                existingTracker.setArrestingAuthority(updatedTrackerModel.getArrestingAuthority());
                existingTracker.setProsecutor(updatedTrackerModel.getProsecutor());

                // Save the updated tracker model
                TrackerModel updatedTracker = trackerRepository.save(existingTracker);
                log.info("Tracker updated successfully with Court File Number: {}", updatedTracker.getCourtFileNo());
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

    public void deleteTracker(String courtFile) {
        try {
            // Retrieve the existing tracker from the database
            Optional<TrackerModel> existingTrackerOptional = trackerRepository.findByCourtFileNo(courtFile);

            if (existingTrackerOptional.isPresent()) {
                TrackerModel existingTracker = existingTrackerOptional.get();

                // Delete the tracker from the database
                trackerRepository.delete(existingTracker);
                log.info("Tracker deleted successfully with Court File Number: {}", courtFile);
            } else {
                log.error("Tracker not found with Court File Number: {}", courtFile);
                throw new RuntimeException("Tracker not found");
            }
        } catch (Exception e) {
            log.error("Error deleting tracker: {}", e.getMessage());
            // You may handle exceptions based on your application requirements
            throw new RuntimeException("Error deleting tracker", e);
        }
    }
}
