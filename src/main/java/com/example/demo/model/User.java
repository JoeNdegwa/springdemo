package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document("customers")
public class User {
    @Id
    private long id;
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

    public User(long id, String phoneNumber, int nationalID, String firstName,
                String middleName, String lastName, String email, Date dob,
                String occupation, Gender gender, MaritalStatus maritalStatus,
                Address address, String kraPIN, LocalDateTime createdAt) {
        this.id = id;
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
    }

}
