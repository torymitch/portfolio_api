package com.api.service.impl;

import com.api.service.UserSvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.model.User;

@Component("userImpl")
public class UserImpl implements UserSvc {

	@Override
	public String getUser(String firstName, String lastName, String userName, String phone) {
		User user = new User(firstName, lastName, userName, phone);
        return user.toString();
    }
	
	@Override
	public List<User> getUsers() {
		List<User> userList = new ArrayList<>();
		User newUser = new User("John", "Smith", "jsmith", "703-908-1675");
		userList.add(newUser);
		return userList;
	}

	@Override
	public User addUser(User user) {
		User newUser = new User(user);
        return newUser;
	}	
    
}