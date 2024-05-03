package com.example.Auth.services;

import com.example.Auth.models.User;
import com.example.Auth.repositories.UserRepository;
import io.jsonwebtoken.Claims;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    public UserService(JwtService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    public ResponseEntity<Map<String, String>> getCurrentUser(String token) {
        String email = jwtService.extractClaim(token, Claims::getSubject);
        User currentUser = userRepository.findByEmail(email).orElseThrow();
        String login = currentUser.getLogin();
        String firstname = currentUser.getFirstName();
        String lastname = currentUser.getLastName();
        byte[] picture = currentUser.getPhoto();

        Map<String, String> userData = new HashMap<>();
        userData.put("email", email);
        userData.put("login", login);
        userData.put("firstname", firstname);
        userData.put("lastname", lastname);
        userData.put("picture", picture != null ? Base64.getEncoder().encodeToString(picture) : null);

        return ResponseEntity.ok(userData);
    }
}