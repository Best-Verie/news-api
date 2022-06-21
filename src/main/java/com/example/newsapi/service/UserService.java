package com.example.newsapi.service;

import com.example.newsapi.dto.CreateUserDto;
import com.example.newsapi.model.User;
import com.example.newsapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
//import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

////    @Autowired
//    private PasswordEncoder bcryptEncoder;


    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }


    public ResponseEntity<?> registerUser(CreateUserDto user) {
        System.out.println(user);
        Optional<User> userEmailFound = userRepository.findByEmail(user.getEmail()) ;
        Optional<User> userUsernameFound = userRepository.findByUsername(user.getUsername()) ;
        if(userEmailFound.isPresent() || userUsernameFound.isPresent()) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        User newUser = new User();
        newUser.setEmail(user.getEmail().toLowerCase());
        newUser.setUsername(user.getUsername().toLowerCase());
        newUser.setFirst_name(user.getFirst_name());
        newUser.setLast_name(user.getLast_name());
        newUser.setRole(user.getRole());
//        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));

        return ResponseEntity.ok(userRepository.save(newUser));
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }
}
