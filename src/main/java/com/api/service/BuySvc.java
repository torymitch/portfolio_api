package com.api.service;

//import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.api.model.Buy;

@Component("buySvc")
public interface BuySvc {
	
	public Buy addBuy(Buy buy);
	
	public Optional<Buy> findById(Integer id);
	
//	public List<Buy> findAllBuysByPositionId(Integer positionId);

	
}
