package com.anz.codechallenge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.anz.codechallenge.entity.TransactionEntity;
import com.anz.codechallenge.models.CurrencyCode;
import com.anz.codechallenge.models.DebitCredit;
import com.anz.codechallenge.models.Transaction;
import com.anz.codechallenge.repository.TransactionsRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestTransactionsService {
	
	@Autowired
	private TransactionsServiceImpl service;
	
	@MockBean
	private TransactionsRepository repository;
	
	@Test
	public void getAccountTransactionsTest() {
		
		BigDecimal b = new BigDecimal(9540.98);
		TransactionEntity entity = new TransactionEntity("847498496", "AUCURRENT591", LocalDate.now(), CurrencyCode.SGD, null, b, DebitCredit.CREDIT, "Some credit");
		List<TransactionEntity> list = Arrays.asList(entity);
		
		when(repository.findByAccountNumber("847498496")).thenReturn(list);
		
		List<Transaction> transactionList = service.getAccountTransactions("847498496");
		assertThat(list.size() == transactionList.size());
		assertThat(list.get(0).getAccountNumber().equals(transactionList.get(0).getAccountNumber()));
	}
	
	@Test
	public void getAllTransactionsTest() {
		
		BigDecimal b = new BigDecimal(9540.98);
		TransactionEntity entity = new TransactionEntity("847498496", "AUCURRENT591", LocalDate.now(), CurrencyCode.SGD, null, b, DebitCredit.CREDIT, "Some credit");
		List<TransactionEntity> list = Arrays.asList(entity);
		
		when(repository.findAll()).thenReturn(list);
		
		List<Transaction> transactionList = service.getAllTransactions();
		assertThat(list.size() == transactionList.size());
		assertThat(list.get(0).getAccountNumber().equals(transactionList.get(0).getAccountNumber()));
	}

}
