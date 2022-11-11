package com.masai.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BankAccountNotExsists;
import com.masai.exception.BankAlreadyAdded;
import com.masai.exception.NotAnyBankAddedYet;
import com.masai.exception.UserNotLogedinException;
import com.masai.model.BankAccount;
import com.masai.model.CurrentSessionUser;
import com.masai.model.Customer;
import com.masai.model.Wallet;
import com.masai.repository.BankAccountDao;
import com.masai.repository.CustomerDAO;
import com.masai.repository.LogInDAO;
import com.masai.repository.SessionDAO;

import java.util.*;

@Service
public class BanKAccountServiceImpl implements BankAccountService{

	@Autowired
	private BankAccountDao bankDao;
	
	@Autowired
	private SessionDAO sessionDao;
	
	@Autowired
	private CustomerDAO cDao;
	
	@Autowired
	private LogInDAO logInDAO;

	@Override
	public BankAccount addBank(BankAccount bankAccount, String uniqueId) throws UserNotLogedinException,BankAlreadyAdded {

		
		Optional<CurrentSessionUser> currentUser =  sessionDao.findByUuid(uniqueId);
		
		if(!currentUser.isPresent()) {
			throw new UserNotLogedinException("Please Login first");
		}
		
		Optional<Customer> customer =  cDao.findById(currentUser.get().getUserId());
		Wallet wallet = customer.get().getWallet();
		
		Optional<BankAccount> bankAc = bankDao.findById(bankAccount.getAccountNumber());
		
		if(bankAc.isPresent()) {
			throw new BankAlreadyAdded("Bank with "+bankAccount.getAccountNumber()+" this Account Nuber Already Exist");
		}
		
		System.out.println(wallet.getWalletId());
		bankAccount.setWalletId(wallet.getWalletId());
		return bankDao.save(bankAccount);

	}



	@Override
	public BankAccount removeBank(Integer accountNumber, String uniqueId)
			throws BankAccountNotExsists, UserNotLogedinException {
		Optional<CurrentSessionUser> currentUser =  sessionDao.findByUuid(uniqueId);
		
		if(!currentUser.isPresent()) {
			throw new UserNotLogedinException("Please Login first");
		}
		
		Optional<BankAccount> bankAccount = bankDao.findById(accountNumber);
		
		bankDao.delete(bankAccount.get());
		
		return bankAccount.get();
		
	}

	@Override
	public BankAccount viewBankAccountI(Integer accountNumber, String uniqueId)
			throws BankAccountNotExsists, UserNotLogedinException {
		
		Optional<CurrentSessionUser> currentUser =  sessionDao.findByUuid(uniqueId);
		
		if(!currentUser.isPresent()) {
			throw new UserNotLogedinException("Please Login first");
		}
		
		Optional<BankAccount> bankAccount = bankDao.findById(accountNumber);
		
		if(bankAccount.isPresent()) {
			return bankAccount.get();
		}else {
			throw new BankAccountNotExsists("Bank account is not existed with current account Number :" + accountNumber);
		}
		
		
	}

	@Override
	public BankAccount viewAllAccount(String uniqueId) throws UserNotLogedinException, NotAnyBankAddedYet, BankAccountNotExsists {
		Optional<CurrentSessionUser> currentUser =  sessionDao.findByUuid(uniqueId);
		
		if(!currentUser.isPresent()) {
			throw new UserNotLogedinException("Please Login first");
		}
		
		Optional<Customer> customer =  cDao.findById(currentUser.get().getUserId());
		Wallet wallet = customer.get().getWallet();
		
		BankAccount bankAccounts= bankDao.findByWalletId(wallet.getWalletId());
		
		if(bankAccounts!=null) {
			return bankAccounts;
		}else {
			throw new BankAccountNotExsists("Bank account is not existed in current user ");
		}
		
		
	}

}
