package com.spring.card.cardservice.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.spring.card.cardservice.model.Card;
import com.spring.card.cardservice.repository.CardRepo;

@Service
public class CardService {

	private CardRepo cardRepo;
	
	
	public CardService(CardRepo cardRepo) {
		this.cardRepo = cardRepo;
	}


	public String addCardDetails(Card cardDetails) {
		if(null != cardDetails) {
			cardDetails.setCreateDt(new Date().toString());
			cardRepo.save(cardDetails);
			return "saved!";
		}
		
		return null;
	}
	
	public List<Card> getCardDetails(String customerId) {
		if(StringUtils.isNotBlank(customerId)) {
			List<Card> existingCardDetails = cardRepo.findByCustomerId(customerId);
			
			if(existingCardDetails.size() > 0 ) {
				return existingCardDetails;
			}
		}
		return null;
	}
}
