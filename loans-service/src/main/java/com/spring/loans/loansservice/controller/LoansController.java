package com.spring.loans.loansservice.controller;
import com.spring.loans.loansservice.model.Customer;
import com.spring.loans.loansservice.model.Loans;
import com.spring.loans.loansservice.service.LoanService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/loans")
@Slf4j
public class LoansController {
    private LoanService loanService;

    public LoansController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public String initialRoute(){
        return "Hello From Loans!";
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLoanData(@RequestBody Loans loans){
        if(null != loans){
            String response = loanService.addLoans(loans);
        }
        return ResponseEntity.ok("Loan Details Added!");
    }
    
    @PostMapping("/all")
    public ResponseEntity<List<Loans>> findLoanDetails(@RequestBody Customer customer){
    	if(null != customer && StringUtils.isNotBlank(customer.getCustomerId())) {
    		log.info("Reached by the FeignClient!");
    		List<Loans> loanList = loanService.getLoanDetails(customer.getCustomerId());
    		if(null != loanList && loanList.size() > 0 ) {
    			log.info("Inside the method findLoanDetails() ends");
    			return ResponseEntity.ok(loanList);
    		}
    	}
    	
    	return ResponseEntity.badRequest().body(null);
    }
}
