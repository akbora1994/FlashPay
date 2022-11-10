package com.masai.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.masai.app.model.Customer;
import com.masai.app.model.LogIn;

@Repository
public interface LogInDAO extends JpaRepository<LogIn, Integer>{
	
	
}
