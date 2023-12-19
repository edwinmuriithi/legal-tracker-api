package com.example.legaltrackerapi.repositories;

import com.example.legaltrackerapi.entities.TrackerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackerRepository extends JpaRepository<TrackerModel, Long> {

}
