package com.api.service.impl;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.Sell;
import com.api.service.SellSvc;
import com.api.service.dao.SellDao;

@Component("sellImpl")
public class SellImpl implements SellSvc {
	
	@Autowired
	private SellDao sellDao;

	@Override
	public Sell addSell(Sell sell) {
		return sellDao.saveSell(sell);
	}
	
	@Override
	public Optional<Sell> findById(Integer id) {
		return sellDao.findById(id);
	}
	
	@Override
	public List<Sell> findByPositionId(Integer id) {
		return sellDao.findByPositionId(id);
	}
		
	@Override
	public void deleteSell(Integer id) {
		sellDao.deleteSell(id);
	}
	

}
