package com.api.service;

import org.springframework.stereotype.Component;

import com.api.model.AccountPosition;

@Component("accountPositionSvc")
public interface AccountPositionSvc {

	public Iterable<AccountPosition> getAccountPositions();
	
	public Iterable<AccountPosition> getAccountPositionsByAccountId(Integer id);
	
	public Iterable<AccountPosition> getAccountPositionsByPositionId(Integer id);
	
	public void deleteAccountPosition(Integer id);
	
	public AccountPosition addAccountPosition(AccountPosition accountPosition);

	public Iterable<AccountPosition> findByAccountIdAndPositionId(Integer accountId, Integer positionId);
	
}
