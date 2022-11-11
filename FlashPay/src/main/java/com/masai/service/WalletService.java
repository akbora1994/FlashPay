package com.masai.service;

import java.math.BigDecimal;

import java.util.*;

import javax.naming.InsufficientResourcesException;

import com.masai.exception.BeneficiaryDetailException;
import com.masai.exception.CustomerNotException;
import com.masai.exception.InsufficientBalanceException;
import com.masai.exception.LoginException;
import com.masai.model.BeneficiaryDetail;
import com.masai.model.Customer;
import com.masai.model.Transaction;
import com.masai.model.Wallet;

public interface WalletService {

	public  Double showBalance(String mobileNo) throws CustomerNotException, LoginException;
	
	public Transaction fundTransfer(String sourceMoblieNo,String targetMobileNo,Double amout,String uniqueId) throws CustomerNotException, BeneficiaryDetailException, LoginException,InsufficientBalanceException;
	
	public Transaction depositeAmount(String uniqueId,Double amount) throws CustomerNotException, LoginException, InsufficientResourcesException, InsufficientBalanceException;
	
	public List<BeneficiaryDetail> getList(String uniqueId) throws CustomerNotException, LoginException, BeneficiaryDetailException;
	
	public Customer addMoney(String uniqueId, Double amount) throws Exception;
	
}
