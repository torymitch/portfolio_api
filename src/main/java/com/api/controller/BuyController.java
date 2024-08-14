package com.api.controller;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Buy addBuy(
			@RequestBody Buy buy,
			@RequestParam(value = "accountId") Integer accountId,
			@RequestParam(value = "positionId") Integer positionId,
			@RequestParam(value = "shares") Float shares,
			@RequestParam(value = "cost") Float cost
			
			) {
		System.out.println("Purchase Made");
		Float costPerShare = cost / shares;
		Float totalCost = cost * shares;
		LocalDate date = LocalDate.now();
		
		buy = new Buy(accountId, positionId, shares, cost, costPerShare, totalCost, date);
		return buySvc.addBuy(buy);
	}
}
