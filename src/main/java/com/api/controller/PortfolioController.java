package com.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Portfolio;

@CrossOrigin
@RestController
public class PortfolioController {
	
	@PostMapping("/addPortfolio")
	public Portfolio addTest(@RequestBody Portfolio portfolio) {
		return portfolio;
	}
}