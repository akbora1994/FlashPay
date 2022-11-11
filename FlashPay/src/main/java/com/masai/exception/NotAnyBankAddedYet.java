package com.masai.exception;

public class NotAnyBankAddedYet extends RuntimeException {

	public NotAnyBankAddedYet() {
	}

	public NotAnyBankAddedYet(String message) {
		super(message);
	}


}
