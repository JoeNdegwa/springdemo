package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.model.Gender;
import com.example.demo.model.MaritalStatus;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    // Max attempts to generate unique customer ID
    private static final int MAX_ATTEMPTS = 10;

    UserRepository userRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User saveUser(String phoneNumber, int nationalID, String firstName, String middleName, String lastName,
                         String email, Date dob, String occupation, Gender gender, MaritalStatus maritalStatus,
                         Address address, String kraPIN, LocalDateTime createdAt) {
        long customerId;
        int attempt = 0;
        do {
            customerId = sequenceGeneratorService.generateUniqueId();
            attempt++;
            if (attempt > MAX_ATTEMPTS) {
                throw new RuntimeException("Failed to generate a unique customer ID after " + MAX_ATTEMPTS + " attempts.");
            }
        } while (userRepository.existsById(customerId));

        User user = new User(customerId, phoneNumber, nationalID, firstName, middleName, lastName,
                email, dob, occupation, gender, maritalStatus, address, kraPIN, LocalDateTime.now());

        return  userRepository.save(user);
    }
}
