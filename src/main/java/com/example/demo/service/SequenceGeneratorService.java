package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SequenceGeneratorService {

    public int generateUniqueId() {
        Random randomObject = new Random();

        return randomObject.nextInt(89) * 887;
    }
}
