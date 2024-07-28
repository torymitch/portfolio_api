package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
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
		return "Access The User Collection";
	}
	
	@GetMapping("/getUsers")
	public Iterable<User> getUsers() {
		System.out.print("Retrieve Users");
		return userSvc.getUsers();
	}
	
	@GetMapping("/getUser")
	public String getUser(@RequestParam(value = "id", defaultValue = "1234") String id) {
		
		String user = userSvc.getUser(id);
		return user;
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User userToUpdate) {
		user = userSvc.updateUser(userToUpdate);
		return user;
	}
	
	@DeleteMapping("/deleteUser")
	public User deleteUser(@RequestParam(value = "id") String id) {
		user = userSvc.deleteUser(id);
		return user;
	}

}
