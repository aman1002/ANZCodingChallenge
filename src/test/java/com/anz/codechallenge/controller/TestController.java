package com.anz.codechallenge.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.anz.codechallenge.models.Account;
import com.anz.codechallenge.models.AccountType;
import com.anz.codechallenge.models.CurrencyCode;
import com.anz.codechallenge.models.DebitCredit;
import com.anz.codechallenge.models.Transaction;
import com.anz.codechallenge.service.AccountServiceImpl;
import com.anz.codechallenge.service.TransactionsServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {AccountController.class, TransactionsController.class})
public class TestController {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private AccountController accountController;
	
	@Autowired
	private TransactionsController transactionController;
	
	@MockBean
	private AccountServiceImpl accountService;
	
	@MockBean
	private TransactionsServiceImpl transactionService;
	
	@Test
	public void getAccountTest() throws Exception {
		
		BigDecimal b = new BigDecimal(84327.51);
		Account account = new Account("585309209", "SGSAVINGS726", AccountType.SAVINGS, LocalDate.now(), CurrencyCode.SGD, b);
		
		when(accountService.getAccount("585309209")).thenReturn(account);
		ResponseEntity<Account> entity = accountController.getAccount("585309209");
		assertEquals(entity.getBody(), account);
		
		mvc.perform(get("/v1/accounts/585309209")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void getAllAccountsTest() throws Exception {
		
		LocalDate date = LocalDate.now();
		BigDecimal b = new BigDecimal(84327.51);
		Account account = new Account("585309209", "SGSAVINGS726", AccountType.SAVINGS, date, CurrencyCode.SGD, b);
		List<Account> list = new ArrayList<>();
		list.add(account);
		
		when(accountService.getAllAccounts()).thenReturn(list);
		ResponseEntity<List<Account>> listEntity = accountController.getAllAccounts();
		assertEquals(listEntity.getBody(), list);
		
		mvc.perform(get("/v1/accounts/")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void getAccountTransactionsTest() throws Exception {
		
		BigDecimal b = new BigDecimal(9540.98);
		Transaction transaction = new Transaction((long) 1, "847498496", "AUCURRENT591", LocalDate.now(), CurrencyCode.SGD, null, b, DebitCredit.CREDIT, "Some credit");
		List<Transaction> list = new ArrayList<>();
		list.add(transaction);
		
		when(transactionService.getAccountTransactions("847498496")).thenReturn(list);
		ResponseEntity<List<Transaction>> listEntity = transactionController.getAccountTransactions("847498496");
		assertEquals(listEntity.getBody(), list);
		
		mvc.perform(get("/v1/transactions/847498496")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void getAllTransactionsTest() throws Exception {
		
		BigDecimal b = new BigDecimal(9540.98);
		Transaction transaction = new Transaction((long) 1, "847498496", "AUCURRENT591", LocalDate.now(), CurrencyCode.SGD, null, b, DebitCredit.CREDIT, "Some credit");
		List<Transaction> list = new ArrayList<>();
		list.add(transaction);
		
		when(transactionService.getAllTransactions()).thenReturn(list);
		ResponseEntity<List<Transaction>> listEntity = transactionController.getAllTransactions();
		assertEquals(listEntity.getBody(), list);
		
		mvc.perform(get("/v1/transactions/")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
