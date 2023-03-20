package com.spring.accounts.accountsservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.accounts.accountsservice.model.Customer;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, String>{

}
