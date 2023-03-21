package com.spring.accounts.accountsservice.model;


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
public class Loans {


    private String loanNumber;

    private String customerId;

    private String loanType;

    private int loanAmount;

    private int amountPaid;

    private int outstandingAmount;

    private String createdDate;

}

