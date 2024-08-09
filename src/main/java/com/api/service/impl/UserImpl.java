package com.api.service.impl;

import com.api.service.UserSvc;
import com.api.service.dao.UserDao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.User;

@Component("userImpl")
public class UserImpl implements UserSvc {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Optional<User> getUserById(Integer id) {
		return userDao.getUserById(id);
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
		return userDao.updateUser(user);
	}

	@Override
	public String deleteUser(Integer id) {
		return userDao.deleteUser(id);
	}
    
}