package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
public class MaxIdService {

    @Autowired
    private MongoOperations mongoOperations;

    public void findGreatestId() {

    }
}
