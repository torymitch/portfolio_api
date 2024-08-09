package com.api.service.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.User;
import com.api.repository.UserRepository;

@Component("userDao")
public class UserDao {
	
	@Autowired 
	private UserRepository userRepository;
	
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public String deleteUser(Integer id) {
		userRepository.deleteById(id);
		return "Success";
	}

	public User updateUser(User user) {
		Optional<User> userToUpd = userRepository.findById(user.getId());
		if (userToUpd != null) {
			return userRepository.save(user);
		}
		return null;
	}

	public Optional<User> getUserById(Integer id) {
		return userRepository.findById(id);
	}
}