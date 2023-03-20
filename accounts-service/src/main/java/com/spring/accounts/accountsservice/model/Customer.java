package com.spring.accounts.accountsservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection="customer")
public class Customer {

	
	private String customerId;
	private String name;
	private String email;
	private String mobileNumber;
	private String createDt;
}
