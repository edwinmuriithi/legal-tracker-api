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
    @Column(length = 100, nullable = false, unique = true)
    private String courtFileNo;
    private String nameOfAccused;
    private String nationality;
    private String gender;
    private String idPassportNo;
    private String magistrate;
    private Date dateOfPlea;
    private String plea;
    private String bondTerms;
    private String bondSuretyName;
    private String suretyDetails;
    private String charge1;
    private String charge2;
    private String charge3;
    private String charge4;
    private String charge5;
    private String species;
    private String exhibit;
    private String weight;
    private Date judgementDate;
    private String judgementOutcome;
    private String sentencing;
    private String caseStatus;
    private String locationOfArrest;
    private String arrestingAuthority;
    private String prosecutor;

}
