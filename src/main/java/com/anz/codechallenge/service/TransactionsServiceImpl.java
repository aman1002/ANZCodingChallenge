package com.anz.codechallenge.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.codechallenge.entity.TransactionEntity;
import com.anz.codechallenge.exceptions.TransactionsNotFoundException;
import com.anz.codechallenge.models.Transaction;
import com.anz.codechallenge.repository.TransactionsRepository;

@Service
@Transactional
public class TransactionsServiceImpl implements TransactionsService {
	
	public static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private TransactionsRepository transactionsRepository;

	@Override
	public List<Transaction> getAccountTransactions(String accountNumber) throws TransactionsNotFoundException {
		
		List<TransactionEntity> transactionEntityList = transactionsRepository.findByAccountNumber(accountNumber);
		log.info("The size of transactions entity list is: "+transactionEntityList.size());
		if (transactionEntityList.isEmpty() || transactionEntityList == null) {
			log.info("Not Found - transactions on Account Number: "+accountNumber);
			throw new TransactionsNotFoundException("Not Found - transactions on Account Number: "+accountNumber);
		}
		List<Transaction> transactionList = new ArrayList<>();
		for(TransactionEntity entity : transactionEntityList) {
			Transaction transaction = new Transaction();
			transaction.setTransactionId(entity.getTransactionId());
			transaction.setAccountName(entity.getAccountName());
			transaction.setAccountNumber(entity.getAccountNumber());
			transaction.setCreditAmount(entity.getCreditAmount());
			transaction.setCurrencyCode(entity.getCurrencyCode());
			transaction.setDebitAmount(entity.getDebitAmount());
			transaction.setDebitCredit(entity.getDebitCredit());
			transaction.setTransactionNarative(entity.getTransactionNarrative());
			transaction.setValueDate(entity.getValueDate());
			
			transactionList.add(transaction);
		}
		return transactionList;
	}

	@Override
	public List<Transaction> getAllTransactions() throws TransactionsNotFoundException {
		
		List<TransactionEntity> transactionEntityList = transactionsRepository.findAll();
		log.info("The size of transactions entity list is: "+transactionEntityList.size());
		if (transactionEntityList.isEmpty() || transactionEntityList == null) {
			log.info("Not Found - no transactions found.");
			throw new TransactionsNotFoundException("Not Found - no transactions found.");
		}
		List<Transaction> transactionList = new ArrayList<>();
		for(TransactionEntity entity : transactionEntityList) {
			Transaction transaction = new Transaction();
			transaction.setTransactionId(entity.getTransactionId());
			transaction.setAccountName(entity.getAccountName());
			transaction.setAccountNumber(entity.getAccountNumber());
			transaction.setCreditAmount(entity.getCreditAmount());
			transaction.setCurrencyCode(entity.getCurrencyCode());
			transaction.setDebitAmount(entity.getDebitAmount());
			transaction.setDebitCredit(entity.getDebitCredit());
			transaction.setTransactionNarative(entity.getTransactionNarrative());
			transaction.setValueDate(entity.getValueDate());
			
			transactionList.add(transaction);
		}
		return transactionList;
	}

}
