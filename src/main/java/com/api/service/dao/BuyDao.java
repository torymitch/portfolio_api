package com.api.service.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.AccountPosition;
import com.api.model.Buy;
import com.api.repository.BuyRepository;
import com.api.service.AccountPositionSvc;

@Component("buyDao")
public class BuyDao {
	
	@Autowired 
	private BuyRepository buyRepository;
	
	@Autowired
	private AccountPositionSvc accountPositionSvc;
	
	@Autowired
	private AccountPosition accountPosition;
	
	public Buy saveBuy(Buy buy) {
		Iterable<AccountPosition> accountPositions = accountPositionSvc.findByAccountIdAndPositionId(buy.getAccountId(), buy.getPositionId());
		if (((List<AccountPosition>) accountPositions).size() == 0 ) {
			accountPosition.setAccountId(buy.getAccountId());
			accountPosition.setPositionId(buy.getPositionId());
			accountPositionSvc.addAccountPosition(accountPosition);
		}
		return buyRepository.save(buy);
	}
	
	public Optional<Buy> findById(Integer id) {
		id = 3;
		Optional<Buy> buy = buyRepository.findById(id);
		return buy;
	}

	public List<Buy> findByPositionId(Integer id) {
		List<Buy> buys = buyRepository.findByPositionId(id);
		return buys;
	}

	public List<Buy> findByShares(Float shares) {
		List<Buy> buys = buyRepository.findByShares(shares);
		return buys;
	}

	public void deleteBuy(Integer id) {
		buyRepository.deleteById(id);
	}

	public List<Buy> fetchBuysByAccountIdAndPositionId(Integer accountId, Integer positionId) {
		return buyRepository.findByAccountIdAndPositionId(accountId, positionId);
	}

	public List<Buy> fetchBuysByAccountId(Integer id) {
		return buyRepository.findByAccountId(id);
	}


}
