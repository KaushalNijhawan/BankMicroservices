package com.spring.accounts.accountsservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "account")
public class AccountModel {

	private String customerId;
	private long accountNumber;
	private String accountType;
	private String branchAddress;
	private String createDt;
}
