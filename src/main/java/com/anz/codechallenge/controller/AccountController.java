package com.anz.codechallenge.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anz.codechallenge.exceptions.AccountNotFoundException;
import com.anz.codechallenge.exceptions.AccountsNotFetchedException;
import com.anz.codechallenge.models.Account;
import com.anz.codechallenge.service.AccountServiceImpl;

@RestController
@RequestMapping("v1/accounts")
public class AccountController {
	
	@Autowired
	private AccountServiceImpl accountService;
	
	private static final Logger log = LoggerFactory.getLogger(AccountController.class);
	
//	API to get account by passing the id as account number
	@GetMapping(path = "/id")
	public ResponseEntity<Account> getAccount(@Valid @RequestBody String accountNumber) {
		Account account = accountService.getAccount(accountNumber);
		if (account == null) {
			log.info("Account Not Found with account number: "+accountNumber);
			throw new AccountNotFoundException("Account Not Found with account number: "+accountNumber);
		}
		log.info("Account fetched is: "+account.toString());
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
//	API to get all the accounts saved in the database for the user
	@GetMapping(path = "/")
	public ResponseEntity<List<Account>> getAllAccounts() {
		List<Account> accountList = accountService.getAllAccounts();
		if (accountList == null || accountList.isEmpty()) {
			log.info("Unable to fetch details from the database.");
			throw new AccountsNotFetchedException("Can't Fetch Details. Server Error");
		}
		log.info("Accounts list fetched properly. "+accountList);
		return new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
	}

}
