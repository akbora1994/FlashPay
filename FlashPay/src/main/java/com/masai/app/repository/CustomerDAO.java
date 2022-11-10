package com.masai.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.app.model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{
	
	public Optional<Customer> findByUserName(String userName);
	
	public Optional<Customer>findByMobileNo(String mobileNo);
}
