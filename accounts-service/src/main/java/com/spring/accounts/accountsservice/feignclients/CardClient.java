package com.spring.accounts.accountsservice.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.accounts.accountsservice.model.Card;
import com.spring.accounts.accountsservice.model.Customer;


@FeignClient(value = "CARD-SERVICE")
public interface CardClient {

	@PostMapping("/cards/all")
	public List<Card> getCardDetails(@RequestBody Customer customer);
}
