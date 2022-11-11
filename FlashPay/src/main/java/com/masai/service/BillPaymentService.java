package com.masai.service;

import java.util.Set;

import com.masai.exception.InsufficientBalanceException;
import com.masai.exception.UserNotLogedinException;
import com.masai.model.BillPayment;

public interface BillPaymentService {
	
	public BillPayment makeBillPayment(BillPayment billpayment,String uniqueId) throws InsufficientBalanceException, UserNotLogedinException;

	public Set<BillPayment> viewBillPayments(String uniqueId) throws UserNotLogedinException;
}
