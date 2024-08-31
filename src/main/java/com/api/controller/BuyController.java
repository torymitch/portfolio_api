package com.api.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<Object> addBuy(@RequestBody Buy buy) {
		try {
			Buy newBuy = buySvc.addBuy(buy);
			if (!ObjectUtils.isEmpty(newBuy)) {
				return (ResponseEntity.ok(newBuy));	
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Buy Record Not Created");

	}
	
	@GetMapping("/fetchBuysByAccountId")
	public ResponseEntity<Object> fetchBuyByAccountId(
			@RequestParam(value = "id") Integer id ) {
		
		try {
			List<Buy> buyList = buySvc.fetchBuysByAccountId(id);
			if (!ObjectUtils.isEmpty(buyList)) {
				return (ResponseEntity.ok(buyList));			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Buy Records Not Retrieved");

	}
	
	@GetMapping("/fetchBuysByAccountIdAndPositionId")
	public ResponseEntity<Object> fetchBuysByAccountIdAndPositionId(
			@RequestParam(value = "accountId") Integer accountId,
			@RequestParam(value = "positionId") Integer positionId 
			) {
		try {
			List<Buy> buyList = buySvc.fetchBuysByAccountIdAndPositionId(accountId, positionId);
			if (!ObjectUtils.isEmpty(buyList)) {
				return (ResponseEntity.ok(buyList));			
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Buy Records Not Retrieved");

	}
	
	
}
