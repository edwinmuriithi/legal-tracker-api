package com.example.legaltrackerapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tracker_model")
public class TrackerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String court_file_no;
    private String name_of_accused;
    private String nationality;
    private String gender;
    private String id_passport_no;
    private String magistrate;
    private Date date_of_plea;
    private String plea;
    private String bond_terms;
    private String bond_surety_name;
    private String surety_details;
    private String charge1;
    private String charge2;
    private String charge3;
    private String charge4;
    private String charge5;
    private String species;
    private String exhibit;
    private String weight;
    private Date judgement_date;
    private String judgement_outcome;
    private String sentencing;
    private String case_status;
    private String location_of_arrest;
    private String arresting_authority;
    private String prosecutor;

}
