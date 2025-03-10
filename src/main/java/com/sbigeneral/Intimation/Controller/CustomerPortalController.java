package com.sbigeneral.Intimation.Controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbigeneral.Intimation.Entity.HealthClaimIntimation;
import com.sbigeneral.Intimation.Entity.MotorClaimIntimation;
import com.sbigeneral.Intimation.Service.ApiService;
import com.sbigeneral.Intimation.Service.ClaimStatusService;
import com.sbigeneral.Intimation.Service.HealthClaimIntimationService;
import com.sbigeneral.Intimation.Service.MotorClaimStatusRequestMappingService;
import com.sbigeneral.Intimation.Service.MotorIntimationDevApi;
import com.sbigeneral.Intimation.model.ClaimsWrapper;
import com.sbigeneral.Intimation.model.FinalRequestDTO;
import com.sbigeneral.Intimation.model.MotorClaimStatusChild1;
import com.sbigeneral.Intimation.model.PolicyIntimationInfo;

@RestController
@RequestMapping("/CustomerPortal")
public class CustomerPortalController {
	
	@Autowired
	private HealthClaimIntimationService healthClaimService;
	
	@Autowired
	private MotorIntimationDevApi motorClaimServiceDevApi;

	@Autowired
	private MotorClaimStatusRequestMappingService requestMappingService;


	@Autowired
	private ClaimStatusService claimStatusService;
	
	@Autowired
	private ApiService apiService;
	
	@Autowired
	private MotorIntimationDevApi motorIntimationService;
	
	private static final Logger logger = LogManager.getLogger(CustomerPortalController.class);
	
	@PostMapping("/getPolicyDetails")
	public ResponseEntity<?> getPolicyDetails(@RequestBody String policyNo) {
		ResponseEntity<?> response = apiService.getPolicyDetails(policyNo);
		
		return response;
	}
	
	@PostMapping("/healthClaimSubmit")
	public ResponseEntity<?> healthClaimSubmit(@RequestBody HealthClaimIntimation obj) {
		ResponseEntity<?> response = healthClaimService.saveDevApiHealthClaimSubmit(obj);
		return response;
	}
	
	@PostMapping("/checkHealthStatus")
	public ResponseEntity<?> healthCheckStatus(@RequestBody Map<String,String> obj) {
		ResponseEntity<?> response = healthClaimService.checkHealthClaimStatus(obj);
		return response;
	}
	
	@PostMapping("/intimateMotorClaim")
	public ResponseEntity<?> motorClaimSubmit(@RequestBody ClaimsWrapper obj) {
		System.out.println(obj);	
		logger.info("The recieved obj is " + obj);
		return motorClaimServiceDevApi.IntimateChatBotService(obj);
	}
	
	@PostMapping("/checkMotorStatus")
	public ResponseEntity<?> checkMotorStatus(@RequestBody MotorClaimStatusChild1 obj) {
		FinalRequestDTO finalObj = requestMappingService.mapRequest(obj);

		System.out.println(finalObj);	
		logger.info("The final obj is " + finalObj);
		return claimStatusService.checkMotorClaimStatus(finalObj);
	}
	
	@PostMapping("/getMotorIntimationDetails")
	public ResponseEntity<?> getMotorPolicyIntimation(@RequestBody String claimNo) {
		ResponseEntity<?> response = motorIntimationService.getMotorIntimationDetailsByClaimNo(claimNo);
		return response;
	}
	
	
	
}
