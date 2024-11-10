package com.example.hotelreservation;

import com.example.hotelreservation.model.User;
import com.example.hotelreservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class HotelReservationApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(HotelReservationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and save a new user with email 'user' and password 'password'
        if (userRepository.findByEmail("user").isEmpty()) {
            User newUser = new User();
            newUser.setFirstName("FirstName");
            newUser.setLastName("LastName");
            newUser.setEmail("user");
            newUser.setEncryptedPassword(passwordEncoder.encode("password"));
            userRepository.save(newUser);
            System.out.println("New user created with email 'user'");
        }

        // Remove the HTTP request during startup
        // The application might not be ready to handle requests at this point
    }
}