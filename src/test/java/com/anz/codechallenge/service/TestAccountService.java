package com.anz.codechallenge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.anz.codechallenge.entity.AccountEntity;
import com.anz.codechallenge.models.Account;
import com.anz.codechallenge.models.AccountType;
import com.anz.codechallenge.models.CurrencyCode;
import com.anz.codechallenge.repository.AccountRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestAccountService {
	
	@Autowired
	private AccountServiceImpl service;
	
	@MockBean
	private AccountRepository repository;
	
	@Test
	public void getAccountTest() {
		
		BigDecimal b = new BigDecimal(84327.51);
		Optional<AccountEntity> entity = Optional.of(new AccountEntity("585309209", "SGSAVINGS726", AccountType.SAVINGS, LocalDate.now(), CurrencyCode.SGD, b));
		
		when(repository.findById("585309209")).thenReturn(entity);
		
		Account account = service.getAccount("585309209");
		assertThat(entity.get().getAccountNumber().equals(account.getAccountNumber()));
	}
	
	@Test
	public void getAllAccountsTest() {
		
		BigDecimal b = new BigDecimal(84327.51);
		AccountEntity entity = new AccountEntity("585309209", "SGSAVINGS726", AccountType.SAVINGS, LocalDate.now(), CurrencyCode.SGD, b);
		List<AccountEntity> list = Arrays.asList(entity);
		
		when(repository.findAll()).thenReturn(list);
		
		List<Account> accountList = service.getAllAccounts();
		assertThat(list.size() == accountList.size());
		assertThat(list.get(0).getAccountNumber().equals(accountList.get(0).getAccountNumber()));
	}

}
