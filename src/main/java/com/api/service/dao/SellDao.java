package com.api.service.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.Sell;
import com.api.repository.SellRepository;

@Component("sellDao")
public class SellDao {
	
	@Autowired 
	private SellRepository sellRepository;
	
	public Sell saveSell(Sell sell) {
		return sellRepository.save(sell);
	}
	
	public Optional<Sell> findById(Integer id) {
		Optional<Sell> sell = sellRepository.findById(id);
		return sell;
	}

	public List<Sell> findByPositionId(Integer id) {
		List<Sell> sells = sellRepository.findByPositionId(id);
		return sells;
	}

	public void deleteSell(Integer id) {
		sellRepository.deleteById(id);
	}


}
