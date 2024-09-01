package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
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
	
	@GetMapping("/getUsers")
	public ResponseEntity<Object> getUsers() {
		try {
			return ResponseEntity.ok(userSvc.getUsers());
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<Object> getUser(@RequestParam(value = "id") Integer id) {
		try {
			return ResponseEntity.ok(userSvc.getUserById(id));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		try {
			User newUser = userSvc.addUser(user);
			if (!ObjectUtils.isEmpty(newUser)) {
				return (ResponseEntity.ok(newUser));	
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("User Record Creation Failed");
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<Object> updateUser(@RequestBody User user) {
		try {
			User updUser = userSvc.updateUser(user);
			if (!ObjectUtils.isEmpty(updUser)) {
				return (ResponseEntity.ok(updUser));	
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("User Record Update Failed");
	}
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<Object> deleteUser(@RequestParam(value = "id") Integer id) {
		try {
			return ResponseEntity.ok(userSvc.deleteUser(id));	
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

}
