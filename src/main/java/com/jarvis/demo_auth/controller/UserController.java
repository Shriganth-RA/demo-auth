package com.jarvis.demo_auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.demo_auth.dtos.RegisterRequest;
import com.jarvis.demo_auth.model.User;
import com.jarvis.demo_auth.service.UserService;

@RestController
//@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
		return userService.register(request);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		return userService.getAllUser();
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "Welcome to dashboard...";
	}
}
