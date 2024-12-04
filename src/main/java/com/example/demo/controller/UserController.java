package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public Optional<User> getUserByName(@RequestParam(value = "id") long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/register")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(
                user.getSalutation(),
                user.getPhoneNumber(),
                user.getNationalID(),
                user.getFirstName(),
                user.getMiddleName(),
                user.getLastName(),
                user.getEmail(),
                user.getDob(),
                user.getOccupation(),
                user.getGender(),
                user.getMaritalStatus(),
                user.getAddress(),
                user.getKraPIN(),
                user.getCreatedAt(),
                user.getModifiedAt(),
                user.getKycStatus(),
                user.getSelfieStatus(),
                user.getCrbStatus(),
                user.getUsername(),
                user.getPassword()
        );
    }
}
