package com.spring.loans.loansservice.repository;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.spring.loans.loansservice.model.Loans;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepo  extends DatastoreRepository<Loans, String> {
	public List<Loans> findByCustomerId(String customerId);
	
	public Loans findByLoanNumber(String loanNumber);

}
