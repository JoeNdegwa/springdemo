package com.example.demo.repository;

import com.example.demo.model.LoadImage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends CrudRepository<LoadImage, Long> {

    Optional<LoadImage> findByName(String name);
}
