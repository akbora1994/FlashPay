package com.masai.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.BillPayment;

@Repository
public interface BillPaymentDao extends JpaRepository<BillPayment, Integer>{
	
	public Set<BillPayment> findByWalletId(Integer walletId);
}
