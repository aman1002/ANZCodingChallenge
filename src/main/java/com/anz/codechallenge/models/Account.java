package com.anz.codechallenge.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {
	
	private String accountNumber;
	private String accountName;
	private AccountType accountType;
	private LocalDate balanceDate;
	private CurrencyCode currencyCode;
	private BigDecimal openingAvailableBalance;
	
	public Account() {
		
	}

	public Account(String accountNumber, String accountName, AccountType accountType, LocalDate balanceDate,
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
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
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

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName
				+ ", accountType=" + accountType + ", balanceDate=" + balanceDate + ", currencyCode=" + currencyCode
				+ ", openingAvailableBalance=" + openingAvailableBalance + "]";
	}

}
