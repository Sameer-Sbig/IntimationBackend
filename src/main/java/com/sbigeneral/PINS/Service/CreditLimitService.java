package com.sbigeneral.PINS.Service;

import java.util.List;

import com.sbigeneral.PINS.Entity.CreditCardLimit;
import com.sbigeneral.PINS.model.CheckLimitRequest;
import com.sbigeneral.PINS.model.CreditCardLimitPopup;
import com.sbigeneral.PINS.model.CreditLimitResponse;
import com.sbigeneral.PINS.model.CreditTransactionLimit;
import com.sbigeneral.PINS.model.ParentCreditModel;

public interface CreditLimitService {
	
	
	
	public List<CreditLimitResponse> fetchCreditLismit(CheckLimitRequest checkLimitRequest );
	
	public String UpdateTransactiondate(CreditTransactionLimit creditTransactionLimit);
	
	
	public String saveCreditCardDeatils(CreditCardLimitPopup creditcardlimit);
	
	
	public List<CreditCardLimit> FetchCreditCardDetails(String AgrementCode);
	
	public List<String> fetchChildCodeDetails(String parentcode);
	public List<ParentCreditModel> fetchParentCodeDetails(String parentcode);
	
	

}
