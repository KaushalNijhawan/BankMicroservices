package com.spring.card.cardservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "card")
public class Card {
	
	private String cardId;

	private String customerId;

	private String cardNumber;

	private String cardType;

	private int totalLimit;

	private int amountUsed;

	private int availableAmount;

	private String createDt;
}
