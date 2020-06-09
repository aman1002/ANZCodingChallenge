package com.anz.codechallenge.service;

import java.util.List;

import com.anz.codechallenge.models.Transaction;

public interface TransactionsService {

	public List<Transaction> getAccountTransactions(String accountNumber);
	public List<Transaction> getAllTransactions();

}
