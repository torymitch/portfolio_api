package com.api.service.impl;

import com.api.service.UserSvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.model.User;

@Component("userImpl")
public class UserImpl implements UserSvc {
	
	@Override
	public String getUser(String id) {
		String firstName = "Andy";
		String lastName = " Reid";
		String userName = "areid";
		String phone = "7039067849";
		
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

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}	
    
}