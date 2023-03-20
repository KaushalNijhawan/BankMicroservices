package com.spring.accounts.accountsservice.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDetails {

	private AccountModel accounts;
	private List<Card> card;
	private List<Loans> loan;
}
