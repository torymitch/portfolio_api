package com.api.service.impl;

import com.api.service.AccountSvc;
import com.api.service.dao.AccountDao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.Account;

@Component("accountImpl")
public class AccountImpl implements AccountSvc {
	
	@Autowired
	private AccountDao accountDao;

	@Override
	public Iterable<Account> getAccounts() {
		return accountDao.getAccounts();
	}

	@Override
	public Account addAccount(Account account) {
		return accountDao.saveAccount(account);
	}

	@Override
	public Account updateAccount(Account account) {
		return accountDao.updateAccount(account);
	}

	@Override
	public String deleteAccount(Integer id) {
		return accountDao.deleteAccount(id);
	}

	@Override
	public Optional<Account> getAccountById(Integer id) {
		return accountDao.getAccountById(id);
	}

    
}