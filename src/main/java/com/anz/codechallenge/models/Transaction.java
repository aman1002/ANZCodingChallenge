package com.anz.codechallenge.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Transaction {
	
	private Long transactionId;
	private String accountNumber;
	private String accountName;
	private LocalDate valueDate;
	private CurrencyCode currencyCode;
	private BigDecimal debitAmount;
	private BigDecimal creditAmount;
	private DebitCredit debitCredit;
	private String transactionNarrative;
	
	public Transaction() {

	}

	public Transaction(Long transactionId, String accountNumber, String accountName, LocalDate valueDate,
			CurrencyCode currencyCode, BigDecimal debitAmount, BigDecimal creditAmount, DebitCredit debitCredit,
			String transactionNarrative) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.valueDate = valueDate;
		this.currencyCode = currencyCode;
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
		this.debitCredit = debitCredit;
		this.transactionNarrative = transactionNarrative;
	}
	
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
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
	public LocalDate getValueDate() {
		return valueDate;
	}
	public void setValueDate(LocalDate valueDate) {
		this.valueDate = valueDate;
	}
	public CurrencyCode getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(CurrencyCode currencyCode) {
		this.currencyCode = currencyCode;
	}
	public BigDecimal getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}
	public BigDecimal getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}
	public DebitCredit getDebitCredit() {
		return debitCredit;
	}
	public void setDebitCredit(DebitCredit debitCredit) {
		this.debitCredit = debitCredit;
	}
	public String getTransactionNarative() {
		return transactionNarrative;
	}
	public void setTransactionNarative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountNumber=" + accountNumber + ", accountName="
				+ accountName + ", valueDate=" + valueDate + ", currencyCode=" + currencyCode + ", debitAmount="
				+ debitAmount + ", creditAmount=" + creditAmount + ", debitCredit=" + debitCredit
				+ ", transactionNarrative=" + transactionNarrative + "]";
	}

}
