package com.api.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Sell;
import com.api.service.SellSvc;

@CrossOrigin
@RestController
public class SellController {
	
	@Autowired
	private SellSvc sellSvc;

	@CrossOrigin
	@PostMapping("/addSell")
	public ResponseEntity<Sell> addSell(
			@RequestBody Sell sell,
			@RequestParam(value = "accountId") Integer accountId,
			@RequestParam(value = "positionId") Integer positionId,
			@RequestParam(value = "shares") Float shares,
			@RequestParam(value = "soldPrice") Float soldPrice
			
			) {
		
		sell = new Sell(accountId, positionId, shares, soldPrice, LocalDate.now());
		return ResponseEntity.ok(sellSvc.addSell(sell));
	}
}
