package com.api.service.impl;

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

}
