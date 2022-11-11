package com.masai.service;

import com.masai.model.*;
import com.masai.exception.LoginException;

public interface CustomerService {
	
	public Customer createNewSignUp(Customer signUp) throws LoginException;;
	
	public Customer updateSignUpDetails(Customer signUp,String key) throws LoginException;
}
