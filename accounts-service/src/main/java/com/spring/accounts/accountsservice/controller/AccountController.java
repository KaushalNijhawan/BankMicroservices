package com.spring.accounts.accountsservice.controller;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.accounts.accountsservice.model.AccountModel;
import com.spring.accounts.accountsservice.model.Customer;
import com.spring.accounts.accountsservice.model.CustomerDetails;
import com.spring.accounts.accountsservice.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/accounts")
@Slf4j
public class AccountController {
//	@Value("${accounts.mailDetails.hostName}")
//	String value;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/default")
	public String defaultValue() {
		return "Welcome to the Accounts Service Cluster!";
	}

	@PostMapping("/customer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
		if(null != customer && null != customer.getCustomerId() && null != customer.getEmail()
				&& null != customer.getMobileNumber() && null != customer.getName()) {
			String response = accountService.addCustomer(customer);
			if(null != response) {
				return ResponseEntity.ok("Customer Saved!"); 
			}
		}
		
		return ResponseEntity.badRequest().body("Invalid Payload!");
	}

	
	@PostMapping("/append")
	public ResponseEntity<String> addCustomer(@RequestBody AccountModel account){
		if(null != account && 0 != account.getAccountNumber() && null != account.getBranchAddress()
				&& null != account.getCustomerId() && null != account.getAccountType()) {
			String response = accountService.addAccount(account);
			if(null != response) {
				return ResponseEntity.ok("Account Details Added!");
			}
		}
		
		return ResponseEntity.badRequest().body("Invalid Payload!");
	}
	
	@GetMapping
//	@Timed(value = "getValue.time", description = "Time Required to get Response" )
	public ResponseEntity<String> getValue() {
		return ResponseEntity.ok("value");
	}
	
	@PostMapping("/customerDetails")
	public ResponseEntity<CustomerDetails> getCustomerDetails(@RequestBody Customer customer){
		if(null != customer && StringUtils.isNotBlank(customer.getCustomerId()) ) {
			log.info("Inside the customerDetails Route in the Accounts Microservices ");
			CustomerDetails custDetails = accountService.getCustomerDetails(customer);
			if(null != custDetails) {
				log.info("End of the method getCustomerDetails()");
				return ResponseEntity.ok(custDetails);
			}
		}
		
		return ResponseEntity.badRequest().body(null);
	}
}
