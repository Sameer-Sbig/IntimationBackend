package com.sbigeneral.Intimation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sbigeneral.Intimation.Service.ApiService;

@Controller
public class CustomerPortalController {

	@Autowired
	private ApiService apiService;
	
	@PostMapping("/getPolicyDetailCustomerPortal")
	public ResponseEntity<?> getPolicyDetails(@RequestBody String policyNo) {
		ResponseEntity<?> response = apiService.getPolicyDetails(policyNo);
		
		return response;
	}
}
