package com.jarvis.demo_auth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jarvis.demo_auth.UserRepo;
import com.jarvis.demo_auth.dtos.RegisterRequest;
import com.jarvis.demo_auth.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public ResponseEntity<String> register(RegisterRequest request) {
		Optional<User> existingUser = userRepo.findByUsername(request.getUsername());
		
		if (existingUser.isPresent()) {
			return ResponseEntity
					.status(HttpStatus.FORBIDDEN)
					.body("User already registered...");
		}
		
		User user = new User();
		
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(request.getRole());
		
		userRepo.save(user);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body("User resgistered successfully...");
	}
	
	
	public ResponseEntity<List<User>> getAllUser() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userRepo.findAll());
	}
	
}