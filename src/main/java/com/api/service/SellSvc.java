package com.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.api.model.Sell;

@Component("sellSvc")
	
	public interface SellSvc {
	
	public Sell addSell(Sell sell);
	
	public void deleteSell(Integer id);
	
	public Optional<Sell> findById(Integer id);
	
	public List<Sell> findByPositionId(Integer positionId);
	
}
