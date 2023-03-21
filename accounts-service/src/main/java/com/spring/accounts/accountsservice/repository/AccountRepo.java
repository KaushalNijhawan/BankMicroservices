package com.spring.accounts.accountsservice.repository;



import org.springframework.stereotype.Repository;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreWriter;
import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.spring.accounts.accountsservice.model.AccountModel;

@Repository
public interface AccountRepo extends DatastoreRepository<AccountModel, Long>{
	
	public AccountModel findByCustomerId(String customerId);
}
