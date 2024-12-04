package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document("users")
public class User {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private BigInteger id;
    private Salutation salutation;
    @Indexed(unique = true)
    private String phoneNumber;
    @Indexed(unique = true)
    private int nationalID;
    private String firstName;
    private String middleName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private Date dob;
    private String occupation;
    private Gender gender;
    private MaritalStatus maritalStatus;
    private Address address;
    @Indexed(unique = true)
    private String kraPIN;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private KYC kycStatus;
    private SELFIE selfieStatus;
    private CRB crbStatus;
    private String username;
    private String password;

    public User(BigInteger id, Salutation salutation, String phoneNumber, int nationalID, String firstName,
                String middleName, String lastName, String email, Date dob,
                String occupation, Gender gender, MaritalStatus maritalStatus,
                Address address, String kraPIN, LocalDateTime createdAt, LocalDateTime modifiedAt,
                KYC kycStatus, SELFIE selfieStatus, CRB crbStatus, String username, String password) {
        this.id = id;
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
        this.address = address;
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
