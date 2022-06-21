package com.coderscampus.Assignment14.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.domain.User;
import com.coderscampus.Assignment14.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public  void save(User user) {
		userRepo.save(user);
		
	}
	public  User createUser(String username) {
		User user = new User();
		user.setName(username);
		return userRepo.save(user);
		
	}
	
	public User findByName(String name) {
	
		return userRepo.findByName(name);
	}

	public Optional<User> findById(Long userId) {
	
		return userRepo.findById(userId);
	}

	public String findName(Long userId) {
		Optional<User> user = userRepo.findById(userId);
		
	String name = user.get().getName();
		return name;
	}
}