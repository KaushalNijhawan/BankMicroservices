package com.spring.accounts.accountsservice.model;



import org.springframework.data.annotation.Id;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;

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
@Entity(name="customer")
public class Customer {

	@Id
	private Long id;
	private String customerId;
	private String name;
	private String email;
	private String mobileNumber;
	private String createDt;
}
