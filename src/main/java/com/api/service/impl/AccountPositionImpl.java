package com.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.AccountPosition;
import com.api.service.AccountPositionSvc;
import com.api.service.dao.AccountPositionDao;

@Component("accountPositionImpl")
public class AccountPositionImpl implements AccountPositionSvc {
	
	@Autowired
	private AccountPositionDao accountPositionDao;

	@Override
	public Iterable<AccountPosition> getAccountPositions() {
		return accountPositionDao.getAccountPositions();
	}

	@Override
	public Iterable<AccountPosition> getAccountPositionsByAccountId(Integer id) {
		return accountPositionDao.getAccountPositionsByAccountId(id);
	}

	@Override
	public Iterable<AccountPosition> getAccountPositionsByPositionId(Integer id) {
		return accountPositionDao.getAccountPositionsByPositionId(id);
	}

	@Override
	public void deleteAccountPosition(Integer id) {
		accountPositionDao.deleteAccountPosition(id);
	}

	@Override
	public AccountPosition addAccountPosition(AccountPosition accountPosition) {
		accountPositionDao.saveAccountPoisition(accountPosition);
		return null;
	}

	@Override
	public Iterable<AccountPosition> findByAccountIdAndPositionId(Integer accountId, Integer positionId) {
		
		return accountPositionDao.findByAccountIdAndPositionId(accountId, positionId);
	}

}
