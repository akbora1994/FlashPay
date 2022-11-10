package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;


@Entity
public class BillPayment {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer billId;
	
	private BillType billtype;
	
	private TransactionType transactionType;
	
	@DecimalMin(value = "0.1", inclusive = true)
	private Double amount;
	
	private LocalDateTime time;
	
	private Integer walletId;

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public BillType getBilltype() {
		return billtype;
	}

	public void setBilltype(BillType billtype) {
		this.billtype = billtype;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	
	public Double getAmount() {
		return amount;
	}

	
	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public LocalDateTime getTime() {
		return time;
	}

	
	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}


	
	
	
	
	
}
