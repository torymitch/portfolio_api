package com.api.service.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.Account;
import com.api.repository.AccountRepository;

@Component("accountDao")
public class AccountDao {
	
	@Autowired 
	private AccountRepository accountRepository;
	
	public Iterable<Account> getAccounts() {
		return accountRepository.findAll();
	}
	
	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}

	public String deleteAccount(Integer id) {
		accountRepository.deleteById(id);
		return "Success";
	}

	public Account updateAccount(Account account) {
		Optional<Account> accountToUpd = accountRepository.findById(account.getId());
		if (accountToUpd != null) {
			return accountRepository.save(account);
		}
		return null;
	}

	public Optional<Account> getAccountById(Integer id) {
		return accountRepository.findById(id);
	}
}