package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BillNotExisttException;
import com.masai.exception.InsufficientBalanceException;
import com.masai.exception.UserNotLogedinException;
import com.masai.model.BillPayment;
import com.masai.service.BillPaymentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import java.util.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/billPayment")
public class BillPaymentController {
	
	@Autowired
	private BillPaymentService bService;
	
	@PostMapping("/{uniqueId}")
	public ResponseEntity<BillPayment> addNewBillPaymentDetails(@RequestBody BillPayment billPayment, @PathVariable String uniqueId) throws UserNotLogedinException, InsufficientBalanceException {
		BillPayment addBill =  bService.makeBillPayment(billPayment, uniqueId);
		return new ResponseEntity<BillPayment> (addBill, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Set<BillPayment>> viewAllBillPayments(@PathVariable("id") String uniqueId) throws UserNotLogedinException{
		Set<BillPayment> billPayments = bService.viewBillPayments(uniqueId);
		return new ResponseEntity<Set<BillPayment>>(billPayments,HttpStatus.ACCEPTED);
	}
	
}
