package com.sbigeneral.Intimation.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sbigeneral.Intimation.Entity.HealthClaimIntimation;
import com.sbigeneral.Intimation.Service.HealthClaimIntimationService;
import com.sbigeneral.Intimation.Service.MotorIntimationDevApi;
import com.sbigeneral.Intimation.model.ClaimsWrapper;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://ansappsuat.sbigen.in", "http://localhost:5173",
		"http://172.18.115.105:7003/PINS", "http://172.16.232.92:7002/PIN", "https://commonsecure.sbigen.in/VBIM/",
		"https://uatcld.sbigeneral.in" })

@PropertySource("classpath:log4j2.properties")
public class claimIntimationController {

	@Autowired
	private HealthClaimIntimationService healthClaimService;

	@Autowired
	private MotorIntimationDevApi motorClaimServiceDevApi;
	private static final Logger logger = LogManager.getLogger(claimIntimationController.class);

	@PostMapping("/healthClaimIntimation")
	public ResponseEntity<?> saveHealthClaimIntimation(@RequestBody HealthClaimIntimation obj) {
		return healthClaimService.saveHealthClaim(obj);
	}


	
	@PostMapping("/intimateMotorClaim")
	public ResponseEntity<?> intimateMotorClaim(@RequestBody ClaimsWrapper obj){
		System.out.println(obj);	
		logger.info("The recieved obj is " + obj);
		return motorClaimServiceDevApi.IntimateChatBotService(obj);
	}
	


}
