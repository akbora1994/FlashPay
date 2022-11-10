package com.masai.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
public class Wallet {
   
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer walletId;
	
	private Double balance;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToMany
	@JsonIgnore
	private List<Transaction> transaction;
	
	@OneToMany
	@JsonIgnore
	private List<BillPayment> billpayments;
	
	@OneToMany
	@JsonIgnore
	private List<BeneficiaryDetail> beneficiaryDetails;
	
	

	
	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	
	public List<BeneficiaryDetail> getBeneficiaryDetails() {
		return beneficiaryDetails;
	}

	public void setBeneficiaryDetails(List<BeneficiaryDetail> beneficiaryDetails) {
		this.beneficiaryDetails = beneficiaryDetails;
	}

	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<BillPayment> getBillpayments() {
		return billpayments;
	}

	public void setBillpayments(List<BillPayment> billpayments) {
		this.billpayments = billpayments;
	}


	
}
