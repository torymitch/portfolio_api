package com.api.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.api.model.User;

@Component("userSvc")
public interface UserSvc {
    
	public String getUser(String id);
	
	public List<User> getUsers();
	
	public User addUser(User user);
	
	public User updateUser(User user);

	public User deleteUser(String id);
	
}
	