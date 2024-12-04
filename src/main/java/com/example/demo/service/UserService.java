package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User saveUser(Salutation salutation, String phoneNumber, int nationalID, String firstName,
                         String middleName, String lastName,String email, Date dob, String occupation,
                         Gender gender, MaritalStatus maritalStatus,Address address, String kraPIN,
                         LocalDateTime createdAt, LocalDateTime modifiedAt,
                         KYC kycStatus, SELFIE selfieStatus, CRB crbStatus,
                         String username, String password) {
        BigInteger userId = BigInteger.valueOf(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));

        User user = new User(userId, salutation, phoneNumber, nationalID, firstName, middleName, lastName,
                email, dob, occupation, gender, maritalStatus, address, kraPIN, LocalDateTime.now(),
                LocalDateTime.now(), kycStatus, selfieStatus, crbStatus, username, password);

        return  userRepository.save(user);
    }
}
