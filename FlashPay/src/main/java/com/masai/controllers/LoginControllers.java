package com.masai.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.model.LogIn;
import com.masai.model.Customer;
import com.masai.service.LoginService;
import com.masai.service.CustomerService;

@CrossOrigin(origins = "*")
@RestController
public class LoginControllers {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<String> loginHandler(@Valid @RequestBody LogIn loginData) throws LoginException {
		String login = loginService.logInAccount(loginData);
		return new ResponseEntity<String>(login,HttpStatus.OK);
	}
	
	@PatchMapping("/logout")
	public ResponseEntity<String> logOutFromAccount(@RequestParam String key) throws LoginException{
		String logout = loginService.logOutFromAccount(key);
		return new ResponseEntity<String>(logout,HttpStatus.OK);
	}
	
	
	
}
