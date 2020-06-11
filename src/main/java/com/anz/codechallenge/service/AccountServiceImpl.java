package com.anz.codechallenge.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.codechallenge.entity.AccountEntity;
import com.anz.codechallenge.exceptions.AccountNotFoundException;
import com.anz.codechallenge.exceptions.AccountsNotFetchedException;
import com.anz.codechallenge.models.Account;
import com.anz.codechallenge.repository.AccountRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	public static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account getAccount(String accountNumber) throws AccountNotFoundException {
		
		AccountEntity accountEntity;
		try {
			accountEntity = accountRepository.findById(accountNumber).get();
		}
		catch (Exception ex) {
			log.info("Account Not Found with account number: "+accountNumber);
			throw new AccountNotFoundException("Account Not Found with account number: "+accountNumber);
		}

		log.info(String.format("Account with account number - %s is fetched: %s", accountNumber, accountEntity));
		
		Account account = new Account();
		account.setAccountName(accountEntity.getAccountName());
		account.setAccountNumber(accountEntity.getAccountNumber());
		account.setAccountType(accountEntity.getAccountTpe());
		account.setBalanceDate(accountEntity.getBalanceDate());
		account.setCurrencyCode(accountEntity.getCurrencyCode());
		account.setOpeningAvailableBalance(accountEntity.getOpeningAvailableBalance());

		return account;
	}

	@Override
	public List<Account> getAllAccounts() throws AccountsNotFetchedException {
		
		List<AccountEntity> accountEntityList = new ArrayList<>();
		accountEntityList = accountRepository.findAll();
		log.info("The size of accounts entity list is: "+accountEntityList.size());
		if (accountEntityList == null || accountEntityList.isEmpty()) {
			log.info("Can't Fetch Details.");
			throw new AccountsNotFetchedException("Can't Fetch Details. Internal Server Error");
		}
		List<Account> accountList = new ArrayList<>();
		for(AccountEntity entity : accountEntityList) {
			Account account = new Account();
			account.setAccountName(entity.getAccountName());
			account.setAccountNumber(entity.getAccountNumber());
			account.setAccountType(entity.getAccountTpe());
			account.setBalanceDate(entity.getBalanceDate());
			account.setCurrencyCode(entity.getCurrencyCode());
			account.setOpeningAvailableBalance(entity.getOpeningAvailableBalance());
			accountList.add(account);
		}
		return accountList;
	}

}
