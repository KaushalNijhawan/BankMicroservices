package com.spring.accounts.accountsservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.accounts.accountsservice.feignclients.CardClient;
import com.spring.accounts.accountsservice.feignclients.LoansClient;
import com.spring.accounts.accountsservice.model.AccountModel;
import com.spring.accounts.accountsservice.model.Card;
import com.spring.accounts.accountsservice.model.Customer;
import com.spring.accounts.accountsservice.model.CustomerDetails;
import com.spring.accounts.accountsservice.model.Loans;
import com.spring.accounts.accountsservice.repository.AccountRepo;
import com.spring.accounts.accountsservice.repository.CustomerRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;

@Service
public class AccountService {

	@Autowired
	private AccountRepo accountRepo;
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private CardClient cardClient;
	@Autowired
	private LoansClient loanClient;

//	public AccountService(AccountRepo accountRepo, CustomerRepo customerRepo, CardClient cardClient,
//			LoansClient loansClient) {
//		this.accountRepo = accountRepo;
//		this.customerRepo = customerRepo;
//		this.cardClient = cardClient;
//		this.loanClient = loansClient;
//	}

	
	public String addAccount(AccountModel account) {
		if(null != account) {
			account.setCreateDt(new Date().toString());
			accountRepo.save(account);
			
			return "Saved!";
		}
		
		return null;
	}
	
	public String addCustomer(Customer customer) {
		if(null != customer) {
			customer.setCreateDt(new Date().toString());
			
			customerRepo.save(customer);
			
			return "Saved!";
		}
		
		return null;
	}
	
	@CircuitBreaker( name = "defaultCustomerDetails", fallbackMethod = "getCustomerDetailsDefault")
	@Retry(name = "retryCustomerDetails", fallbackMethod = "getCustomerDetailsDefault")
	public CustomerDetails getCustomerDetails(Customer customer) {
		if(null != customer) {
			List<Loans> loanList = loanClient.findLoanDetails(customer);
			List<Card> card = cardClient.getCardDetails(customer);
			AccountModel account = accountRepo.findByCustomerId(customer.getCustomerId());
			CustomerDetails custDetails = new CustomerDetails();
			
			custDetails.setAccounts(account);
			custDetails.setCard(card);
			custDetails.setLoan(loanList);
			return custDetails;
		}
		return null;
	}
	
	private CustomerDetails getCustomerDetailsDefault(Customer customer, Throwable t){
		if(null != customer) {
//			List<Card> card = cardClient.getardDetails(customer);
			List<Loans> loanList = loanClient.findLoanDetails(customer);
			AccountModel account = accountRepo.findByCustomerId(customer.getCustomerId());
			CustomerDetails custDetails = new CustomerDetails();
			
			custDetails.setAccounts(account);
			custDetails.setCard(new ArrayList<Card>());
//			custDetails.setCard(card);
			custDetails.setLoan(loanList);
			return custDetails;
		}
		return null;
	}
	
	
}
