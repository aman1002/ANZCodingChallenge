package com.anz.codechallenge.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.anz.codechallenge.models.AccountType;
import com.anz.codechallenge.models.CurrencyCode;

@Entity
@Table(name = "account")
public class AccountEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Pattern(regexp = "[0-9]{9}")
	private String accountNumber;
	private String accountName;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	private LocalDate balanceDate;
	@Enumerated(EnumType.STRING)
	private CurrencyCode currencyCode;
	private BigDecimal openingAvailableBalance;
	
	public AccountEntity() {
		
	}

	public AccountEntity(String accountNumber, String accountName, AccountType accountType, LocalDate balanceDate,
			CurrencyCode currencyCode, BigDecimal openingAvailableBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.accountType = accountType;
		this.balanceDate = balanceDate;
		this.currencyCode = currencyCode;
		this.openingAvailableBalance = openingAvailableBalance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public AccountType getAccountTpe() {
		return accountType;
	}

	public void setAccountTpe(AccountType accountType) {
		this.accountType = accountType;
	}

	public LocalDate getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(LocalDate balanceDate) {
		this.balanceDate = balanceDate;
	}

	public CurrencyCode getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(CurrencyCode currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getOpeningAvailableBalance() {
		return openingAvailableBalance;
	}

	public void setOpeningAvailableBalance(BigDecimal openingAvailableBalance) {
		this.openingAvailableBalance = openingAvailableBalance;
	}
	
}
