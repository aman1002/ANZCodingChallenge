package com.anz.codechallenge.service;

import java.util.List;

import com.anz.codechallenge.models.Account;

public interface AccountService {
	
	public Account getAccount(String accountNumber);
	public List<Account> getAllAccounts();

}
