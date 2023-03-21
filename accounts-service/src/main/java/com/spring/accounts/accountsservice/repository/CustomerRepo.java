package com.spring.accounts.accountsservice.repository;

import org.springframework.stereotype.Repository;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.spring.accounts.accountsservice.model.Customer;

@Repository
public interface CustomerRepo extends DatastoreRepository<Customer, String>{

}
