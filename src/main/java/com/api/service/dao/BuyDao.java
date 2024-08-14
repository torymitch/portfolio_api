package com.api.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.Buy;
import com.api.repository.BuyRepository;

@Component("buyDao")
public class BuyDao {
	
	@Autowired 
	private BuyRepository buyRepository;
	
	public Buy saveBuy(Buy buy) {
		return buyRepository.save(buy);
	}


}
