package com.api.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Buy;
import com.api.service.BuySvc;

@CrossOrigin
@RestController
public class BuyController {
	
	@Autowired
	private BuySvc buySvc;

	@CrossOrigin
	@PostMapping("/addBuy")
	public ResponseEntity<Buy> addBuy(
			@RequestBody Buy buy,
			@RequestParam(value = "accountId") Integer accountId,
			@RequestParam(value = "positionId") Integer positionId,
			@RequestParam(value = "shares") Float shares,
			@RequestParam(value = "costPerShare") Float costPerShare,
			@RequestParam(value = "totalCost") Float totalCost
			
			) {
		
		buy = new Buy(accountId, positionId, shares, costPerShare, totalCost, LocalDate.now());
		return ResponseEntity.ok(buySvc.addBuy(buy));
	}
}
