package com.masai.controllers;

import java.math.BigDecimal;

import java.util.List;

import javax.naming.InsufficientResourcesException;

import org.hibernate.validator.constraints.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BeneficiaryDetailException;
import com.masai.exception.CustomerNotException;
import com.masai.exception.InsufficientBalanceException;
import com.masai.exception.LoginException;
import com.masai.model.BeneficiaryDetail;
import com.masai.model.CurrentSessionUser;
import com.masai.model.Customer;
import com.masai.model.Transaction;
import com.masai.model.Wallet;
import com.masai.repository.SessionDAO;
import com.masai.service.CurrentUserSessionServiceImpl;
import com.masai.service.CustomerServiceImpl;
import com.masai.service.WalletServiceImpl;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private WalletServiceImpl walletServiceImpl;

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@Autowired
	private CurrentUserSessionServiceImpl currentuserSesionServiceImpl;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<String> viewWalletBalance(@PathVariable("id") String uniqueId) throws CustomerNotException, LoginException{
		Double balance = walletServiceImpl.showBalance(uniqueId);
		return new ResponseEntity<String>(("wallet balanace is : "+ balance) , HttpStatus.CREATED);
	}
 

	@PutMapping("/fundtran/{sourceMobileNo}/{tragetMobileNo}/{amount}/{uniqueId}")
	public ResponseEntity<Transaction> WalletTOWalletTransfer(@PathVariable("sourceMobileNo") String sourceMobileNo,
			@PathVariable("tragetMobileNo") String tragerMobileNo, @PathVariable("amount") Double amount,@PathVariable("uniqueId") String uniqueId)
			throws CustomerNotException, LoginException, BeneficiaryDetailException, InsufficientBalanceException {
		Transaction transaction = walletServiceImpl.fundTransfer(sourceMobileNo, tragerMobileNo, amount,uniqueId);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}

	@PutMapping("/deposite/{id}/{amount}")
	public ResponseEntity<Transaction> depositeAmountFromWalletToBank(@PathVariable("id") String uniqueId,@PathVariable("amount") Double amount)
			throws CustomerNotException, InsufficientResourcesException, LoginException, InsufficientBalanceException {
		Transaction transaction = walletServiceImpl.depositeAmount(uniqueId, amount);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}


	@GetMapping("/getbenList/{uniqueid}")
	public ResponseEntity<List<BeneficiaryDetail>> getAllBeneficiaryCoustomerFromWallet(String uniqueId)
			throws CustomerNotException, LoginException, BeneficiaryDetailException {
		List<BeneficiaryDetail> beneficiaryDetails = walletServiceImpl.getList(uniqueId);
		return new ResponseEntity<List<BeneficiaryDetail>>(beneficiaryDetails, HttpStatus.OK);
	}

	@PostMapping("/addMoney/{uniqueid}/{amount}")
	public ResponseEntity<Customer> addMoneyFromBankToWallet(String uniqueId, Double amount) throws Exception {
		Customer customer = walletServiceImpl.addMoney(uniqueId, amount);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

}
