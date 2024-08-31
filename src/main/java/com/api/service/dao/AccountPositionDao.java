package com.api.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.Account;
import com.api.model.AccountPosition;
import com.api.repository.AccountPositionRepository;

@Component("accountPositionDao")
public class AccountPositionDao {
	
	@Autowired 
	private AccountPositionRepository accountPositionRepository;
	
	public Iterable<AccountPosition> getAccountPositions() {
		return accountPositionRepository.findAll();
	}
	
	public AccountPosition saveAccountPoisition(AccountPosition accountPosition) {
		return accountPositionRepository.save(accountPosition);
	}
	
	public Iterable<AccountPosition> getAccountPositionsByAccountId(Integer accountId) {
		return accountPositionRepository.findByAccountId(accountId);
	}
	
	public Iterable<AccountPosition> getAccountPositionsByPositionId(Integer positionId) {
		return accountPositionRepository.findByPositionId(positionId);
	}
	
	public Iterable<AccountPosition> findByAccountIdAndPositionId(Integer accountId, Integer positionId) {
		return accountPositionRepository.findByAccountIdAndPositionId(accountId, positionId);
	}
	
	public void deleteAccountPosition(Integer id) {
		accountPositionRepository.deleteById(id);
	}


}
