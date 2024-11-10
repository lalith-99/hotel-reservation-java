package com.example.hotelreservation.repository;

import com.example.hotelreservation.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);  // Ensure this returns Optional<User>
}
