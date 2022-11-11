package com.masai.service;

import java.util.List;

import com.masai.exception.BeneficiaryDetailException;
import com.masai.model.BeneficiaryDetail;
import com.masai.model.Customer;

public interface BeneficiaryDetailServices {
	public BeneficiaryDetail addBeneficiary(String uniqueId,BeneficiaryDetail beneficiaryDetail) throws BeneficiaryDetailException;
	public BeneficiaryDetail deleteBeneficiary(String uniqueId,String benficiaryMobileNo) throws BeneficiaryDetailException;
	public List<BeneficiaryDetail> viewBeneficiaryByMobileNo(String beneficiaryMobileNo) throws BeneficiaryDetailException;
	public List<BeneficiaryDetail> viewAllBeneficiary(String uniqueId) throws BeneficiaryDetailException;
}
