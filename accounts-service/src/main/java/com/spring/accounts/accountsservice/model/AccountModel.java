package com.spring.accounts.accountsservice.model;


import org.springframework.data.annotation.Id;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;

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
//@Document(collection  = "account")
@Entity(name="account")
public class AccountModel {
	private String customerId;
	@Id
	private long accountNumber;
	private String accountType;
	private String branchAddress;
	private String createDt;
}
