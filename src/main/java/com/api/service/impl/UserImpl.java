package com.api.service.impl;

import com.api.service.UserSvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.model.User;

@Component("userImpl")
public class UserImpl implements UserSvc {
	
	protected List<User> getUuserData() {
		List<User> users  = new ArrayList<>();
		User user1 = new User("Donovan", "McNabb", "dmcnabb", "703-190-7498");
		User user2 = new User("Randall", "Cunningham", "rcunningham", "703-240-6098");
		User user3 = new User("Jalen", "Hurts", "jhurts", "703-240-3565");
		User user4 = new User("Carson", "Wentz", "cwentz", "703-240-6789");
		User user5 = new User("Michael", "Vick", "mvick", "703-240-9401");
		User user6 = new User("Ron", "Jaworski", "rjaws", "703-240-7101");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);
		return users;
	}
	
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
		List<User> userList = this.getUuserData();
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