package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Salutation salutation;
    @Column(unique=true)
    private String phoneNumber;
    @Column(unique=true)
    private int nationalID;
    private String firstName;
    private String middleName;
    private String lastName;
    @Column(unique=true)
    private String email;
    private Date dob;
    private String occupation;
    private Gender gender;
    private MaritalStatus maritalStatus;
    @Column(unique=true)
    private String kraPIN;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private KYC kycStatus;
    private SELFIE selfieStatus;
    private CRB crbStatus;
    @Column(unique=true)
    private String username;
    private String password;

    public User(Salutation salutation, String phoneNumber, int nationalID, String firstName,
                String middleName, String lastName, String email, Date dob,
                String occupation, Gender gender, MaritalStatus maritalStatus,
                String kraPIN, LocalDateTime createdAt, LocalDateTime modifiedAt,
                KYC kycStatus, SELFIE selfieStatus, CRB crbStatus, String username, String password) {
        this.salutation = salutation;
        this.phoneNumber = phoneNumber;
        this.nationalID = nationalID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.occupation = occupation;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.kraPIN = kraPIN;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.kycStatus = kycStatus;
        this.selfieStatus = selfieStatus;
        this.crbStatus = crbStatus;
        this.username = username;
        this.password = password;
    }

}
