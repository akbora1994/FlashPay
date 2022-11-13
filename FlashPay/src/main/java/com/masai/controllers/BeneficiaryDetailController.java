package com.masai.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BeneficiaryDetailException;
import com.masai.model.BeneficiaryDetail;
import com.masai.model.Customer;
import com.masai.service.BeneficiaryDetailServices;
import com.masai.service.LoginServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ben")
public class BeneficiaryDetailController {
	
	@Autowired
	private BeneficiaryDetailServices beneficiaryService;
	
	@PostMapping("/{id}")
	public ResponseEntity<BeneficiaryDetail> addBeneficiaryDetail(@PathVariable("id") String uuid,@Valid @RequestBody BeneficiaryDetail beneficiaryDetail) throws BeneficiaryDetailException{
		BeneficiaryDetail saved = beneficiaryService.addBeneficiary(uuid,beneficiaryDetail);
		return new ResponseEntity<BeneficiaryDetail>(saved,HttpStatus.CREATED);
	}
	@DeleteMapping("/del")
	public ResponseEntity<BeneficiaryDetail>deleteBeneficiaryDetail(@Valid @RequestParam String uuid,@Valid @RequestParam String beneficiaryMobileNo) throws BeneficiaryDetailException{
		BeneficiaryDetail deleted = beneficiaryService.deleteBeneficiary(uuid,beneficiaryMobileNo);
		return new ResponseEntity<BeneficiaryDetail>(deleted,HttpStatus.OK);
	}
	@GetMapping("/{beneficiaryMobileNo}")
	public ResponseEntity<List<BeneficiaryDetail>>findBeneficiaryDetailByMobNo(@Valid @PathVariable("beneficiaryMobileNo") String MobNo) throws BeneficiaryDetailException{
		List<BeneficiaryDetail> beneficiaryDetail = beneficiaryService.viewBeneficiaryByMobileNo(MobNo);
		return new ResponseEntity<List<BeneficiaryDetail>>(beneficiaryDetail,HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<BeneficiaryDetail>>findBeneficiaryDetailByCustomer(@Valid @RequestParam String uuid) throws BeneficiaryDetailException{
		List<BeneficiaryDetail> list = beneficiaryService.viewAllBeneficiary(uuid);
		return new ResponseEntity<List<BeneficiaryDetail>>(list,HttpStatus.OK);
	}
}
