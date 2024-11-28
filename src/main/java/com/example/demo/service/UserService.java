package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.model.Gender;
import com.example.demo.model.MaritalStatus;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

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
                         Address address, String kraPIN) {
        long id = sequenceGeneratorService.generateSequence("customer_sequence");
        User user = new User(id, phoneNumber, nationalID, firstName, middleName, lastName,
                email, dob, occupation, gender, maritalStatus, address, kraPIN);

        return  userRepository.save(user);
    }
}
