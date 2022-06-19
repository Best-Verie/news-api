package com.example.newsapi.service;

import com.example.newsapi.model.User;
import com.example.newsapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }


    public ResponseEntity<?> registerUser(User user) {
        Optional<User> userEmailFound = userRepository.findByEmail(user.getEmail()) ;
        Optional<User> userUsernameFound = userRepository.findByUsername(user.getUsername()) ;
        if(userEmailFound.isPresent() || userUsernameFound.isPresent()) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        return ResponseEntity.ok(userRepository.save(user));
    }



}
