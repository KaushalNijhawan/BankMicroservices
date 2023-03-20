package com.spring.accounts.accountsservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.accounts.accountsservice.model.AccountModel;

@Repository
public interface AccountRepo extends MongoRepository<AccountModel, Long>{
	
	public AccountModel findByCustomerId(String customerId);
}
