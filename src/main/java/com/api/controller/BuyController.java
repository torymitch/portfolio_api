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
			@RequestParam(value = "account_id") Integer account_id,
			@RequestParam(value = "position_id") Integer position_id,
			@RequestParam(value = "shares") Float shares,
			@RequestParam(value = "cost") Float cost
			
			) {
		System.out.println("Purchase Made");
		Float cost_per_share = cost / shares;
		Float total_cost = cost * shares;
		LocalDate date = LocalDate.now();
		
		buy = new Buy(account_id, position_id, shares, cost, cost_per_share, total_cost, date);
		return buySvc.addBuy(buy);
	}
}
