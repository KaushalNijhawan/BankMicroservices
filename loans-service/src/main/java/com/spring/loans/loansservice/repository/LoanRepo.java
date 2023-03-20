package com.spring.loans.loansservice.repository;

import com.spring.loans.loansservice.model.Loans;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepo  extends MongoRepository<Loans, String> {
	public List<Loans> findByCustomerId(String customerId);
	
	public Loans findByLoanNumber(String loanNumber);

}
