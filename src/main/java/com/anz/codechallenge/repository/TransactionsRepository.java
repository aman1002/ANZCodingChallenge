package com.anz.codechallenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.codechallenge.entity.TransactionEntity;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionEntity, Long> {
	
//	Retrieve transaction from the database by using account number as search parameter
	public List<TransactionEntity> findByAccountNumber(String accountNumber);

}
