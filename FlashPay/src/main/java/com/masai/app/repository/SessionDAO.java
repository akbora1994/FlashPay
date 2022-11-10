package com.masai.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.app.model.CurrentSessionUser;
import com.masai.app.model.Customer;

@Repository
public interface SessionDAO extends JpaRepository<CurrentSessionUser, Integer>{
	
	public Optional<CurrentSessionUser> findByUserId(Integer userId);
	
	public Optional<CurrentSessionUser> findByUuid(String uuid);
	
	public Optional<CurrentSessionUser> findByMobileNo(String uuid);
	
	
	
}
