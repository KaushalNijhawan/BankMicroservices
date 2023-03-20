package com.spring.loans.loansservice.model;

import lombok.*;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document(collection = "loans")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Loans {

    @MongoId(value = FieldType.STRING)
    private String loanNumber;

    private String customerId;

    private String loanType;

    private int loanAmount;

    private int amountPaid;

    private int outstandingAmount;

    private String createdDate;

}
