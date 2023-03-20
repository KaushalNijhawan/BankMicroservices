package com.spring.card.cardservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.card.cardservice.model.Card;

public interface CardRepo extends MongoRepository<Card, String>{

	public List<Card> findByCustomerId(String customerId);
	
	public Card findByCardId(String cardId);
}
