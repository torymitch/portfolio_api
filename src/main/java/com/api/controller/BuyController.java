package com.api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.AccountPosition;
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
	
	@GetMapping("/fetchBuysByAccountId")
	public ResponseEntity<List<Buy>> fetchBuyByAccountId(
			@RequestParam(value = "id") Integer id ) {
		return ResponseEntity.ok(buySvc.fetchBuysByAccountId(id));
	}
//	
//	@GetMapping("/getBuysByPositionId")
//	public ResponseEntity<Iterable<AccountPosition>> getBuysByPositionId(
//			@RequestParam(value = "id") Integer id ) {
//		return ResponseEntity.ok(buySvc.getAccountPositionsByAccountId(id));
//	}
	
	@GetMapping("/fetchBuysByAccountIdAndPositionId")
	public ResponseEntity<List<Buy>> fetchBuysByAccountIdAndPositionId(
			@RequestParam(value = "accountId") Integer accountId,
			@RequestParam(value = "positionId") Integer positionId 
			) {
		return ResponseEntity.ok(buySvc.fetchBuysByAccountIdAndPositionId(accountId, positionId));
	}
}
