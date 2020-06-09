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

import com.anz.codechallenge.exceptions.TransactionsNotFoundException;
import com.anz.codechallenge.models.Transaction;
import com.anz.codechallenge.service.TransactionsServiceImpl;

@RestController
@RequestMapping("v1/transactions")
public class TransactionsController {
	
	@Autowired
	private TransactionsServiceImpl transactionService;
	
//	API to get all the transactions for a particular account number
	@GetMapping(path = "/{accountNumber}")
	public ResponseEntity<List<Transaction>> getAccountTransactions(@Valid @PathVariable String accountNumber) {
		List<Transaction> transactionList = transactionService.getAccountTransactions(accountNumber);
		if (transactionList.isEmpty() || transactionList.equals(null))
			throw new TransactionsNotFoundException("Not Found - transactions on Account Number: "+accountNumber);
		return new ResponseEntity<List<Transaction>>(transactionList, HttpStatus.OK);
	}
	
//	API to get all the transactions in the database for the user
	@GetMapping(path = "/")
	public ResponseEntity<List<Transaction>> getAllTransactions() {
		List<Transaction> transactionList = transactionService.getAllTransactions();
		if (transactionList.isEmpty() || transactionList.equals(null))
			throw new TransactionsNotFoundException("Not Found - no transactions found.");
		return new ResponseEntity<List<Transaction>>(transactionList, HttpStatus.OK);
	}

}
