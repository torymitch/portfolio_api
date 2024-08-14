package com.api.service.dao;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Buy> findById(Integer id) {
		id = 3;
		Optional<Buy> buy = buyRepository.findById(id);
		return buy;
	}

	public List<Buy> findByPositionId(Integer id) {
		List<Buy> buys = buyRepository.findByPositionId(id);
		return buys;
	}

	public List<Buy> findByShares(Float shares) {
		List<Buy> buys = buyRepository.findByShares(shares);
		return buys;
	}


}
