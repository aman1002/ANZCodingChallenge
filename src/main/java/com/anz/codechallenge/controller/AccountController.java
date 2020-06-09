package com.anz.codechallenge.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
//	API to get account by passing the id as account number
	@GetMapping(path = "/{accountNumber}")
	public ResponseEntity<Account> getAccount(@Valid @PathVariable String accountNumber) {
		Account account = accountService.getAccount(accountNumber);
		if (account.equals(null))
			throw new AccountNotFoundException("Account Not Found with account number: "+accountNumber);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
//	API to get all the accounts saved in the database for the user
	@GetMapping(path = "/")
	public ResponseEntity<List<Account>> getAllAccounts() {
		List<Account> accountList = accountService.getAllAccounts();
		if (accountList.equals(null) || accountList.isEmpty())
			throw new AccountsNotFetchedException("Can't Fetch Details. Server Error");
		return new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
	}

}
