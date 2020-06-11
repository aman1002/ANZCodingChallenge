package com.anz.codechallenge.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.anz.codechallenge.models.CurrencyCode;
import com.anz.codechallenge.models.DebitCredit;

@Entity
@Table(name = "transaction")
public class TransactionEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	@Pattern(regexp = "[0-9]{9}")
	private String accountNumber;
	private String accountName;
	private LocalDate valueDate;
	@Enumerated(EnumType.STRING)
	private CurrencyCode currencyCode;
	private BigDecimal debitAmount;
	private BigDecimal creditAmount;
	@Enumerated(EnumType.STRING)
	private DebitCredit debitCredit;
	private String transactionNarrative;
	
	public TransactionEntity() {
		
	}
	
	public TransactionEntity(String accountNumber, String accountName, LocalDate valueDate, CurrencyCode currencyCode,
			BigDecimal debitAmount, BigDecimal creditAmount, DebitCredit debitCredit, String transactionNarrative) {
		super();
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
	public String getTransactionNarrative() {
		return transactionNarrative;
	}
	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}
	
}
