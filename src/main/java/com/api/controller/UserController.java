package com.api.controller;

import java.util.Optional;

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
	private UserSvc userSvc;
	
	@GetMapping("/user")
	public String user() {
		return "Access The User Collection";
	}
	
	@GetMapping("/getUsers")
	public Iterable<User> getUsers() {
		System.out.print("Retrieve All Users");
		return userSvc.getUsers();
	}
	
	@GetMapping("/getUser")
	public Optional<User> getUser(@RequestParam(value = "id") Integer id) {
		
		Optional<User> user = userSvc.getUserById(id);
		return user;
	}
	
	@PostMapping("/addUser")
	public User addUser(
			@RequestBody User user,
			@RequestParam(value = "first_name") String first_name,
			@RequestParam(value = "last_name") String last_name,
			@RequestParam(value = "phone_number") String phone_number,
			@RequestParam(value = "user_name") String user_name,
			@RequestParam(value = "email_address") String email_address
			
		) {
		user = new User(first_name, last_name, user_name, phone_number, email_address);
		System.out.println("Add The User " + user);
		user = userSvc.addUser(user);
		return user;
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user,
			@RequestParam(value = "id") Integer id,
			@RequestParam(value = "first_name") String first_name,
			@RequestParam(value = "last_name") String last_name,
			@RequestParam(value = "phone_number") String phone_number,
			@RequestParam(value = "user_name") String user_name,
			@RequestParam(value = "email_address") String email_address) {
		user = new User(id, first_name, last_name, user_name, phone_number, email_address);
		System.out.println("Add The User " + user);
		user = userSvc.updateUser(user);
		return user;
	}
	
	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestParam(value = "id") Integer id) {
		userSvc.deleteUser(id);
		return "Success";
	}

}
