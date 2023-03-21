package com.spring.loans.loansservice.model;

import lombok.*;

import org.springframework.data.annotation.Id;
import com.google.cloud.spring.data.datastore.core.mapping.Entity;

@Entity(name="loans")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Loans {
	@Id
	private Long id;
	
    private String loanNumber;

    private String customerId;

    private String loanType;

    private int loanAmount;

    private int amountPaid;

    private int outstandingAmount;

    private String createdDate;

}
