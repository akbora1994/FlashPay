package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BeneficiaryDetailException;
import com.masai.model.BeneficiaryDetail;
import com.masai.model.CurrentSessionUser;
import com.masai.model.Customer;
import com.masai.model.Wallet;
import com.masai.repository.BeneficiaryDetailDao;
import com.masai.repository.CustomerDAO;


import com.masai.repository.SessionDAO;
import com.masai.repository.WalletDao;

@Service
public class BeneficiaryDetailServicesImpl implements BeneficiaryDetailServices {
	@Autowired
	private BeneficiaryDetailDao bDao;
	@Autowired
	private SessionDAO sDao;
	@Autowired
	private WalletDao wDao;
	@Autowired
	private CustomerDAO customerDao;
	

	@Override
	public BeneficiaryDetail addBeneficiary(String uniqueId,BeneficiaryDetail beneficiaryDetail) throws BeneficiaryDetailException {
		Optional<CurrentSessionUser> currentSessionUser= sDao.findByUuid(uniqueId);
		if(currentSessionUser.isPresent()) {
			Optional<Customer> userOptional=customerDao.findById(currentSessionUser.get().getUserId());
			if(userOptional.isPresent()) {
				Wallet wallet = userOptional.get().getWallet();
				beneficiaryDetail.setWalletId(wallet.getWalletId());
				List<BeneficiaryDetail> list = wallet.getBeneficiaryDetails();
				list.add(beneficiaryDetail);
				BeneficiaryDetail saved =bDao.save(beneficiaryDetail);
				return saved;
			}else {
				throw new BeneficiaryDetailException("No Customer found with id "+currentSessionUser.get().getUserId());
			}
		}
		
		else {
			throw new BeneficiaryDetailException("You need to login first!");
		}
	}

	@Override
	public BeneficiaryDetail deleteBeneficiary(String uniqueId,String benficiaryMobile) throws BeneficiaryDetailException {
		Optional<CurrentSessionUser> currentSessionUser= sDao.findByUuid(uniqueId);
		if(currentSessionUser.isPresent()) {
			Optional<Customer> userOptional=customerDao.findById(currentSessionUser.get().getUserId());
			if(userOptional.isPresent()) {
				Customer customer = userOptional.get();
				Wallet wallet = customer.getWallet();
				List<BeneficiaryDetail> list=wallet.getBeneficiaryDetails();
				if(!list.isEmpty()) {
					int index=-1;
					for(int i=0;i<list.size();i++) {
						if(list.get(i).getBeneficiaryMobileNo().equals(benficiaryMobile)) {
							index=i;
							break;
						}
					}
					if(index==-1) throw new BeneficiaryDetailException("Beneficiary Not found");
					BeneficiaryDetail beneficiaryDetail=list.get(index);
					BeneficiaryDetail updated=list.remove(index);
					wallet.setBeneficiaryDetails(list);
					bDao.delete(updated);
					return beneficiaryDetail;
					
				}else {
					throw new BeneficiaryDetailException("There is no beneficiary found in the list");
				}
				
			}else {
				throw new BeneficiaryDetailException("No Customer found with id "+currentSessionUser.get().getUserId());
			}
		}
		
		else {
			throw new BeneficiaryDetailException("You need to login first!");
		}
		
	}

	@Override
	public List<BeneficiaryDetail> viewBeneficiaryByMobileNo(String beneficiaryMobileNo) throws BeneficiaryDetailException {
		List<BeneficiaryDetail> beneficiaryDetail=bDao.findBybeneficiaryMobileNo(beneficiaryMobileNo);
		if(beneficiaryDetail.isEmpty()) {
			throw new BeneficiaryDetailException("No Beneficiary found with Mobile No : "+beneficiaryMobileNo);
		}else {
			return beneficiaryDetail;
		}
	}

	@Override
	public List<BeneficiaryDetail> viewAllBeneficiary(String uniqueId) throws BeneficiaryDetailException {
		Optional<CurrentSessionUser> currentSessionUser= sDao.findByUuid(uniqueId);
		if(currentSessionUser.isPresent()) {
			CurrentSessionUser currUser =  currentSessionUser.get();
			int userid=currUser.getUserId();
			Optional<Customer> customerOpt = customerDao.findById(userid);
			if(customerOpt.isPresent()) {
				Customer customer = customerOpt.get();
				List<BeneficiaryDetail>list =customer.getWallet().getBeneficiaryDetails();
				if(list.isEmpty()) {
					throw new BeneficiaryDetailException("No Beneficiary found in the list");
				}else {
					return list;
				}
			}else {
				throw new BeneficiaryDetailException("You need to login first");
			}
			
		}
		else {
			throw new BeneficiaryDetailException("You need to login first");	
		}
	}



}
