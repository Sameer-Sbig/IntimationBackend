package com.sbigeneral.Intimation.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sbigeneral.Intimation.Service.ApiService;

@Controller
@CrossOrigin(origins = { "http://localhost:4200", "https://ansappsuat.sbigen.in", "http://localhost:5173",
		"http://172.18.115.105:7003/PINS", "http://172.16.232.92:7002/PIN", "https://commonsecure.sbigen.in/VBIM/" , "https://uatcld.sbigeneral.in"})

@PropertySource("classpath:log4j2.properties")
public class fetchDetails {

	@Autowired
	private ApiService apiService;

	@CrossOrigin
	@PostMapping("/getInfo")
	public ResponseEntity<?> getReport(@RequestBody String PolicyNumber) {

		ResponseEntity<?> response = apiService.fetchSecurePolicyInfo(PolicyNumber);
		return response;
	}
	
	@PostMapping("/getIntimationPolicyDetails")
	public ResponseEntity<?> getIntimationPolicyDetails(@RequestBody String PolicyNumber){
		ResponseEntity<?> response = apiService.getPolicyDetails(PolicyNumber);
		
		return response;
	}
	
	@GetMapping("/getPolicyIntimations")
	public ResponseEntity<?> getPolicyInfo() {
		ResponseEntity<?> response = apiService.getPolicyInfo();
		return response;
	}
	
	@PostMapping("/getPolicyIntimationsByRequestId")
	public ResponseEntity<?> getPolicyIntimationInfo(@RequestBody String requestId) {
		ResponseEntity<?> response = apiService.getPolicyIntimations(requestId);
		return response;
	}

}
