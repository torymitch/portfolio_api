package com.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Portfolio;

@CrossOrigin
@RestController
public class PortfolioController {
	
	@PostMapping("/addPortfolio")
	public ResponseEntity<Portfolio> addTest(@RequestBody Portfolio portfolio) {
		return ResponseEntity.ok(portfolio);
	}
}