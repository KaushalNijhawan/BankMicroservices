package com.spring.card.cardservice.repository;

import java.util.List;


import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.spring.card.cardservice.model.Card;

public interface CardRepo extends DatastoreRepository<Card, String>{

	public List<Card> findByCustomerId(String customerId);
	
	public Card findByCardId(String cardId);
}
