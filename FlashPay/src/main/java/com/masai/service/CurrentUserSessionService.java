package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.CurrentSessionUser;
import com.masai.model.Customer;

public interface CurrentUserSessionService {
	public CurrentSessionUser getCurrentUserSession(String key) throws LoginException;;
	public Integer getCurrentUserSessionId(String key) throws LoginException;;
	
	public Customer getSignUpDetails(String key) throws LoginException;;
}
