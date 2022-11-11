package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class BeneficiaryDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer beneficiaryId;
	
	@NotBlank
	@NotNull
	@Size(min = 4,max = 25 ,message = "Name length minimum 4 to 25")
	private String beneficiaryName;
	
	@NotBlank
	@NotNull
	@Size(min = 10,max = 10 ,message = "mobile number must be in 10 digits!")
	private String beneficiaryMobileNo;
	
	private Integer walletId;

	public BeneficiaryDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BeneficiaryDetail(
			@NotBlank @NotNull @Size(min = 4, max = 25, message = "Name length minimum 4 to 25") String beneficiaryName,
			@NotBlank @NotNull @Size(min = 10, max = 10, message = "Mobile number length mustbe 10") String beneficiaryMobileNo,
			Integer walletId) {
		super();
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryMobileNo = beneficiaryMobileNo;
		this.walletId = walletId;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getBeneficiaryMobileNo() {
		return beneficiaryMobileNo;
	}

	public void setBeneficiaryMobileNo(String beneficiaryMobileNo) {
		this.beneficiaryMobileNo = beneficiaryMobileNo;
	}

	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

}
