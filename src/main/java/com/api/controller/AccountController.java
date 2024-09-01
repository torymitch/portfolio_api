package com.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.Account.CreateAccountDto;
import com.api.dto.Account.UpdateAccountDto;
import com.api.model.Account;
import com.api.service.AccountSvc;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@CrossOrigin
@RestController
public class AccountController {
	
	@Autowired
	private AccountSvc accountSvc;
	
	@Autowired
	private Account account;

	@GetMapping("/getAccounts")
	public ResponseEntity<Object> getAccounts() {
		try {
			return ResponseEntity.ok(accountSvc.getAccounts());
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	@PostMapping("/addAccount")
	public ResponseEntity<Object> addAccount(@Valid @RequestBody CreateAccountDto createAccountDto) {
		try {
			
			BeanUtils.copyProperties(createAccountDto, account);
			
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
	public ResponseEntity<Object> updateAccount(@Valid @RequestBody UpdateAccountDto updateAccountDto) {
		try {
			BeanUtils.copyProperties(updateAccountDto, account);
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
	public ResponseEntity<Object> deleteAccount(@NotNull @RequestParam(value = "id") Integer id) {
		try {
			return ResponseEntity.ok(accountSvc.deleteAccount(id));	
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
}