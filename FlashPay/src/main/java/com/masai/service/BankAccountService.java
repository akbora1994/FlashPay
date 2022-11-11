package com.masai.service;

import java.util.Set;

import com.masai.exception.BankAccountNotExsists;
import com.masai.exception.BankAlreadyAdded;
import com.masai.exception.NotAnyBankAddedYet;
import com.masai.exception.UserNotLogedinException;
import com.masai.model.BankAccount;

public interface BankAccountService {
	
	public BankAccount addBank(BankAccount bankAccount,String uniqueId) throws UserNotLogedinException,BankAlreadyAdded;

	public BankAccount removeBank(Integer accountNumber,String uniqueId) throws BankAccountNotExsists,UserNotLogedinException;
	
	public BankAccount viewBankAccountI(Integer accountNumber,String uniqueId) throws BankAccountNotExsists,UserNotLogedinException ;
	
	public BankAccount viewAllAccount(String uniqueId) throws UserNotLogedinException,NotAnyBankAddedYet, BankAccountNotExsists;
}
