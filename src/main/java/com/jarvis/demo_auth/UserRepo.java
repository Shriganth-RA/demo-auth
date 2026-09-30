package com.jarvis.demo_auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jarvis.demo_auth.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);

}
