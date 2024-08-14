package com.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.Buy;
import com.api.service.BuySvc;
import com.api.service.dao.AccountDao;
import com.api.service.dao.BuyDao;

@Component("buyImpl")
public class BuyImpl implements BuySvc {
	
	@Autowired
	private BuyDao buyDao;

	@Override
	public Buy addBuy(Buy buy) {
		return buyDao.saveBuy(buy);
	}
	
	@Override
	public Optional<Buy> findById(Integer id) {
		return buyDao.findById(id);
	}
	
	@Override
	public List<Buy> findByPositionId(Integer id) {
		return buyDao.findByPositionId(id);
	}
	
	@Override
	public List<Buy> findByShares(Float shares) {
		return buyDao.findByShares(shares);
	}
	

}
