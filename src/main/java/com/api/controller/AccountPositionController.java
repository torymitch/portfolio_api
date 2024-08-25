package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
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
	public ResponseEntity<Iterable<AccountPosition>> getAccountPositions() {
		return ResponseEntity.ok(accountPositionSvc.getAccountPositions());
	}
	
	@GetMapping("/getAccountPositionsByAccountId")
	public ResponseEntity<Iterable<AccountPosition>> getAccountPositionsByAccountId(
			@RequestParam(value = "id") Integer id ) {
		return ResponseEntity.ok(accountPositionSvc.getAccountPositionsByAccountId(id));
	}
	
	@GetMapping("/getAccountPositionsByPositionId")
	public ResponseEntity<Iterable<AccountPosition>> getAccountPositionsByPositionId(
			@RequestParam(value = "id") Integer id ) {
		return ResponseEntity.ok(accountPositionSvc.getAccountPositionsByPositionId(id));
	}
	
	@DeleteMapping("/deleteAccountPosition")
	public BodyBuilder deleteAccountPosition(@RequestParam(value = "id") Integer id) {
		accountPositionSvc.deleteAccountPosition(id);
		return ResponseEntity.ok();
	}
}