package com.example.hotelreservation.service;

import com.example.hotelreservation.model.User;
import com.example.hotelreservation.model.CreateUserParams;
import com.example.hotelreservation.repository.UserRepository;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(CreateUserParams params) {
        User user = new User();
        user.setFirstName(params.getFirstName());
        user.setLastName(params.getLastName());
        user.setEmail(params.getEmail());
        user.setEncryptedPassword(passwordEncoder.encode(params.getPassword()));  // Encode the password
        return userRepository.save(user);
    }

    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User with ID " + id + " not found"));
    }
}
