package com.masai.exception;

public class TransactionNotFoundException extends Exception{
	
	public TransactionNotFoundException (){
		
	}
	
	public TransactionNotFoundException (String message){
		super(message);
	}
}
