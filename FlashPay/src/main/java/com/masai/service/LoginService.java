package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.LogIn;

public interface LoginService {
	
	public String logInAccount(LogIn loginData) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;
}
