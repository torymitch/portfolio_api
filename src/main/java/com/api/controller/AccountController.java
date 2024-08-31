package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Account;
import com.api.service.AccountSvc;

@CrossOrigin
@RestController
public class AccountController {
	
	@Autowired
	private AccountSvc accountSvc;

	@GetMapping("/getAccounts")
	public ResponseEntity<Object> getAccounts() {
		try {
			return ResponseEntity.ok(accountSvc.getAccounts());
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	@PostMapping("/addAccount")
	public ResponseEntity<Object> addAccount(@RequestBody Account account) {
		try {
			Account newAccount = accountSvc.addAccount(account);
			if (!ObjectUtils.isEmpty(newAccount)) {
				return (ResponseEntity.ok(newAccount));	
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Account Not Created");
	}
		
	@PutMapping("/updateAccount")
	public ResponseEntity<Object> updateAccount(
			@RequestBody Account account) {
		try {
			Account updAccount = accountSvc.updateAccount(account);
			if (!ObjectUtils.isEmpty(updAccount)) {
				return (ResponseEntity.ok(updAccount));	
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Account Not Created");
	}
	
	@DeleteMapping("/deleteAccount")
	public ResponseEntity<Object> deleteAccount(@RequestParam(value = "id") Integer id) {
		try {
			return ResponseEntity.ok(accountSvc.deleteAccount(id));	
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
}