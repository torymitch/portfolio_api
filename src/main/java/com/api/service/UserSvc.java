package com.api.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.api.model.User;

@Component("userSvc")
public interface UserSvc {

//    public String getUser(String firstName, String lastName);
    
    public User addUser(User user);

	public List<User> getUsers();

	public String getUser(String firstName, String lastName, String userName, String phone);

}
	