package com.api.service;

import org.springframework.stereotype.Component;

import com.api.model.Buy;

@Component("buySvc")
public interface BuySvc {
	
	public Buy addBuy(Buy buy);
	
}
