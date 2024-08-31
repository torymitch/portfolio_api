package com.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.api.model.Buy;

@Component("buySvc")
public interface BuySvc {
	
	public Buy addBuy(Buy buy);
	
	public void deleteBuy(Integer id);
	
	public Optional<Buy> findById(Integer id);
	
	public List<Buy> findByPositionId(Integer positionId);
	
	public List<Buy> findByShares(Float shares);

	public List<Buy> fetchBuysByAccountIdAndPositionId(Integer accountId, Integer positionId);

	public List<Buy> fetchBuysByAccountId(Integer id);
	
}
