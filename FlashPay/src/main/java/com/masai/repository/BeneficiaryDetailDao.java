package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.exception.BeneficiaryDetailException;
import com.masai.model.BeneficiaryDetail;

@Repository
public interface BeneficiaryDetailDao extends JpaRepository<BeneficiaryDetail, Integer>{

	public List<BeneficiaryDetail> findBybeneficiaryMobileNo(String beneficiaryMobileNo) throws BeneficiaryDetailException;
	public List<BeneficiaryDetail> findByWalletId(Integer walletId) throws BeneficiaryDetailException;

}
