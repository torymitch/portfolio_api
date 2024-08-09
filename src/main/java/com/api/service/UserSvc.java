package com.api.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.api.model.User;

@Component("userSvc")
public interface UserSvc {
	
	public Iterable<User> getUsers();
	
	public User addUser(User user);
	
	public User updateUser(User user);

	public String deleteUser(Integer id);

	public Optional<User> getUserById(Integer id);
	
}
	