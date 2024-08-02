package com.api.service.impl;

import com.api.service.UserSvc;
import com.api.service.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.User;

@Component("userImpl")
public class UserImpl implements UserSvc {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public String getUser(String id) {
		String firstName = "Andy";
		String lastName = " Reid";
		String userName = "areid";
		String phone = "7039067849";
		String email = "testEmail@somewhere.com";
		
		User user = new User(firstName, lastName, userName, phone, email);
        return user.toString();
    }
	
	@Override
	public Iterable<User> getUsers() {
		return userDao.getUsers();
	}
	
	@Override
	public User addUser(User user) {
		return userDao.saveUser(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(Integer id) {
		return userDao.deleteUser(id);
	}	
    
}