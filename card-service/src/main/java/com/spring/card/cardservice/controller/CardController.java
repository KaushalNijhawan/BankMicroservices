package com.spring.card.cardservice.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.card.cardservice.model.Card;
import com.spring.card.cardservice.model.Customer;
import com.spring.card.cardservice.service.CardService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/cards")
@Slf4j
public class CardController {

	private CardService cardService;
	
	
	public CardController(CardService cardService) {
		this.cardService = cardService;
	}


	@PostMapping("/append")
	public ResponseEntity<String> addCardDetails(@RequestBody Card cardModel){
		if(null != cardModel && null != cardModel.getCardNumber() &&  cardModel.getAmountUsed() >= 0 
				&& cardModel.getAvailableAmount() >= 0 && cardModel.getTotalLimit() >= 0 &&
				null != cardModel.getCardNumber() ) {
			String response = cardService.addCardDetails(cardModel);
			if(null != response) {
				return ResponseEntity.ok("Card Added!");
			}
		}
		
		return ResponseEntity.badRequest().body("Invalid Payload!");
	}
	
	@PostMapping("/all")
	public ResponseEntity<List<Card>> getCardDetails(@RequestBody Customer customer){
		if(null != customer && StringUtils.isNotBlank(customer.getCustomerId())) {
			log.info("Inside the getCardDetails() method starts ");
			List<Card> cardList = cardService.getCardDetails(customer.getCustomerId());
			if(null != cardList && cardList.size() > 0 ) {
				log.info("Inside the getCardDetails() ends!");
				return ResponseEntity.ok(cardList);
			}
		}
		
		return ResponseEntity.badRequest().body(null);
	}
}
