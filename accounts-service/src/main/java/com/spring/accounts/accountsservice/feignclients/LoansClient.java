package com.spring.accounts.accountsservice.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.accounts.accountsservice.model.Customer;
import com.spring.accounts.accountsservice.model.Loans;


@FeignClient(value="LOANS-SERVICE")
public interface LoansClient {

	@PostMapping("/loans/all")
    public List<Loans> findLoanDetails(@RequestBody Customer customer);
}
