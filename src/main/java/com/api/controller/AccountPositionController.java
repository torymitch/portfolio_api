package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.AccountPosition;
import com.api.service.AccountPositionSvc;

@CrossOrigin
@RestController
public class AccountPositionController {
	
	@Autowired
	private AccountPositionSvc accountPositionSvc;

	@GetMapping("/getAccountPositions")
	public Iterable<AccountPosition> getAccountPositions() {
		return accountPositionSvc.getAccountPositions();
	}
	
	@GetMapping("/getAccountPositionsByAccountId")
	public Iterable<AccountPosition> getAccountPositionsByAccountId(
			@RequestParam(value = "id") Integer id ) {
		return accountPositionSvc.getAccountPositionsByAccountId(id);
	}
	
	@GetMapping("/getAccountPositionsByPositionId")
	public Iterable<AccountPosition> getAccountPositionsByPositionId(
			@RequestParam(value = "id") Integer id ) {
		return accountPositionSvc.getAccountPositionsByPositionId(id);
	}
	
	@DeleteMapping("/deleteAccountPosition")
	public String deleteAccountPosition(@RequestParam(value = "id") Integer id) {
		accountPositionSvc.deleteAccountPosition(id);
		return "Success";
	}
}