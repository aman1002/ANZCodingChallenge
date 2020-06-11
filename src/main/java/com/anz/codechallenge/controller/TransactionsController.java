package com.anz.codechallenge.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anz.codechallenge.exceptions.TransactionsNotFoundException;
import com.anz.codechallenge.models.Transaction;
import com.anz.codechallenge.service.TransactionsServiceImpl;
import com.anz.codechallenge.validator.AccountValidator;

@RestController
@RequestMapping("v1/transactions")
public class TransactionsController {
	
	@Autowired
	private TransactionsServiceImpl transactionService;
	
	private static final Logger log = LoggerFactory.getLogger(TransactionsController.class);
	
//	API to get all the transactions for a particular account number
	@GetMapping(path = "/id")
	public ResponseEntity<List<Transaction>> getAccountTransactions(@RequestBody String accountNumber) {
		AccountValidator.validateAccountNumber(accountNumber);
		List<Transaction> transactionList = transactionService.getAccountTransactions(accountNumber);
		if (transactionList.isEmpty() || transactionList == null) {
			log.info("Not Found - transactions on Account Id: "+accountNumber);
			throw new TransactionsNotFoundException("Not Found - transactions on Account Number: "+accountNumber);
		}
		log.info("Transaction fetched properly. "+transactionList);
		return new ResponseEntity<List<Transaction>>(transactionList, HttpStatus.OK);
	}
	
//	API to get all the transactions in the database for the user
	@GetMapping(path = "/")
	public ResponseEntity<List<Transaction>> getAllTransactions() {
		List<Transaction> transactionList = transactionService.getAllTransactions();
		if (transactionList.isEmpty() || transactionList == null) {
			log.info("Not Found - no transactions found in the database.");
			throw new TransactionsNotFoundException("Not Found - no transactions found.");
		}
		log.info("Transaction fetched properly. "+transactionList);
		return new ResponseEntity<List<Transaction>>(transactionList, HttpStatus.OK);
	}

}
