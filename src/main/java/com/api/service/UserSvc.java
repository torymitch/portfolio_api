package com.api.service;

import org.springframework.stereotype.Component;

import com.api.model.User;

@Component("userSvc")
public interface UserSvc {
    
	public String getUser(String id);
	
	public Iterable<User> getUsers();
	
	public User addUser(User user);
	
	public User updateUser(User user);

	public User deleteUser(String id);
	
}
	