package com.payment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.domain.Banks;
import com.payment.domain.Customers;
import com.payment.repository.BankRepository;

@RestController
@RequestMapping("/banks")
public class BankController {
	public final BankRepository bankRepo;
	
	public BankController(BankRepository bankRepo) {
		super();
		this.bankRepo = bankRepo;
	}

	@GetMapping("/")
	public List<Banks> getCustomers() {
		return bankRepo.findAll();
	}

}
