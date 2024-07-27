package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.model.User;
import com.api.service.UserSvc;


@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private User user;
	
	@Autowired
	private UserSvc userSvc;
	
	@GetMapping("/user")
	public String user() {
		return "Welcome Boys and Girls";
	}
	
	@GetMapping("/getUsers")
	public List<User> getUsers() {
		List<User> userList = userSvc.getUsers();
		return userList;
	}

	@GetMapping("/getUser")
	public String getUser( 
			@RequestParam(value = "firstName", defaultValue = "Johnny") String firstName,
			@RequestParam(value = "lastName", defaultValue = "Appleseed") String lastName,
			@RequestParam(value = "userName", defaultValue = "jappleseed") String userName,
			@RequestParam(value = "phone", defaultValue = "555-555-5555") String phone
		) {
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		String newUser = userSvc.getUser(user.getFirstName(), user.getLastName(), user.getUserName(), user.getPhone());
		
		return newUser;
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		User newUser = userSvc.addUser(user);
		return newUser;
	}

	/* 	
		@GetMapping
		@PostMapping
		@PutMapping
		@DeleteMapping
		@PatchMapping
	*/

}
