package com.spring.loans.loansservice.service;

import com.spring.loans.loansservice.model.Loans;
import com.spring.loans.loansservice.repository.LoanRepo;
import lombok.AllArgsConstructor;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoanService {

    private LoanRepo loanRepo;
    
    public LoanService(LoanRepo loanRepo) {
		this.loanRepo = loanRepo;
	}
    public String addLoans(Loans loan){
        if(null != loan) {
            loan.setCreatedDate(new Date().toString());
            loan.setLoanNumber(loan.getCustomerId());
            loanRepo.save(loan);
            return "saved";
        }
        return null;
    }
    
    public List<Loans> getLoanDetails(String customerId){
    	if(StringUtils.isNotBlank(customerId)) {
    		List<Loans> loansList = loanRepo.findByCustomerId(customerId);
    		
    		if(loansList.size() > 0 ) {
    			return loansList;
    		}
    	}
    	
    	return null;
    }
}
