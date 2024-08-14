package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Iterable<Account> getAccounts() {
		return accountSvc.getAccounts();
	}
	
	@PostMapping("/addAccount")
	public Account addAccount(
		@RequestBody Account account,
		@RequestParam(value = "name") String name,
		@RequestParam(value = "number") String number,
		@RequestParam(value = "user_id") Integer user_id
	) {
		account = new Account(name, number);
		return accountSvc.addAccount(account);
	}
	
	@PutMapping("/updateAccount")
	public Account updateAccount(
			@RequestBody Account account,
			@RequestParam(value = "id") Integer id,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "number") String number,
			@RequestParam(value = "user_id") Integer user_id
			) {
		account = new Account(id, name, number, user_id);
		return accountSvc.updateAccount(account);
	}
	
	@DeleteMapping("/deleteAccount")
	public String deleteAccount(@RequestParam(value = "id") Integer id) {
		return accountSvc.deleteAccount(id);
	}
}