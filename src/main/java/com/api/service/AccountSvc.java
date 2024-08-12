package com.api.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.api.model.Account;

@Component("accountSvc")
public interface AccountSvc {
	
	public Iterable<Account> getAccounts();
	
	public Account addAccount(Account account);
	
	public Account updateAccount(Account account);

	public String deleteAccount(Integer id);

	public Optional<Account> getAccountById(Integer id);
	
}
	