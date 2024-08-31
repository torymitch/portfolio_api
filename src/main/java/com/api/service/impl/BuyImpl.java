package com.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.Buy;
import com.api.service.BuySvc;
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
	
	@Override
	public void deleteBuy(Integer id) {
		buyDao.deleteBuy(id);
	}

	@Override
	public List<Buy> fetchBuysByAccountIdAndPositionId(Integer accountId, Integer positionId) {
		return buyDao.fetchBuysByAccountIdAndPositionId(accountId, positionId);
	}

	@Override
	public List<Buy> fetchBuysByAccountId(Integer id) {
		return buyDao.fetchBuysByAccountId(id);
	}
	

}
