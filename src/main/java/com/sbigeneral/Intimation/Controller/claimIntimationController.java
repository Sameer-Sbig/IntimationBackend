package com.sbigeneral.Intimation.Controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.sbigeneral.Intimation.Entity.HealthClaimIntimation;
import com.sbigeneral.Intimation.Repository.HealthClaimIntimationRepo;
import com.sbigeneral.Intimation.Service.ClaimStatusService;
import com.sbigeneral.Intimation.Service.Decrypt;
import com.sbigeneral.Intimation.Service.Encrypt;
import com.sbigeneral.Intimation.Service.HealthClaimIntimationService;
import com.sbigeneral.Intimation.Service.MotorClaimStatusRequestMappingService;
import com.sbigeneral.Intimation.Service.MotorIntimationDevApi;
import com.sbigeneral.Intimation.model.ClaimsWrapper;
import com.sbigeneral.Intimation.model.FinalRequestDTO;
import com.sbigeneral.Intimation.model.MotorClaimStatusChild1;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://ansappsuat.sbigen.in", "http://localhost:5173",
		"http://172.18.115.105:7003/PINS", "http://172.16.232.92:7002/PIN", "https://commonsecure.sbigen.in/VBIM/",
		"https://uatcld.sbigeneral.in" })

@PropertySource("classpath:log4j2.properties")
public class claimIntimationController {

	@Autowired
	private HealthClaimIntimationService healthClaimService;
	
	@Autowired
	private Decrypt decrypt;
	
	@Autowired
	private Encrypt encrypt;

	@Autowired
	private MotorIntimationDevApi motorClaimServiceDevApi;

	@Autowired
	private MotorClaimStatusRequestMappingService requestMappingService;


	@Autowired
	private ClaimStatusService claimStatusService;
	
	private static final Logger logger = LogManager.getLogger(claimIntimationController.class);

	@PostMapping("/intimateMotorClaim")
	public ResponseEntity<?> intimateMotorClaim(@RequestBody ClaimsWrapper obj){
		System.out.println(obj);	
		logger.info("The recieved obj is " + obj);
		return motorClaimServiceDevApi.IntimateChatBotService(obj);
	}
	
	@PostMapping("/healthClaimIntimation")
	public ResponseEntity<?> saveHealthClaimIntimation(@RequestBody HealthClaimIntimation obj) {
		ResponseEntity<?> response = healthClaimService.saveDevApiHealthClaim(obj);
		return response;
	}
	
	@PostMapping("/healthClaimSubmit")
	public ResponseEntity<?> saveHealthClaimSubmit(@RequestBody HealthClaimIntimation obj) {
		ResponseEntity<?> response = healthClaimService.saveDevApiHealthClaimSubmit(obj);
		return response;
	}
	
	@PostMapping("/encryptAES-256-CBC")
	public ResponseEntity<String> encrypt(@RequestBody Object obj) {
		try {
			String encryptedData = encrypt.aes256cbcEncrypt(obj);
			return new ResponseEntity<String>(encryptedData , HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/decryptAES-256-CBC")
	public ResponseEntity<String> decrypt(@RequestBody String encryptedData) {
		try {
			String decryptedData = decrypt.aes256cbcDecrypt(encryptedData);
			
			return new ResponseEntity<String>(decryptedData , HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	@PostMapping("/checkMotorStatus")
	public ResponseEntity<?> checkMotorStatus(@RequestBody MotorClaimStatusChild1 obj) {
		//TODO: process POST request
		FinalRequestDTO finalObj = requestMappingService.mapRequest(obj);

		System.out.println(finalObj);	
		logger.info("The final obj is " + finalObj);
		return claimStatusService.checkMotorClaimStatus(finalObj);
		
	}
	
	@PostMapping("/checkHealthStatus")
	public ResponseEntity<?> checkHealthStatus(@RequestBody Map<String,String> obj) {
		ResponseEntity<?> response = healthClaimService.checkHealthClaimStatus(obj);
		return response;
	}

	@PostMapping("/mapRequest")
    public FinalRequestDTO mapRequest(@RequestBody MotorClaimStatusChild1 requestBodyDTO) {
        return requestMappingService.mapRequest(requestBodyDTO);
    }
	
	

	


}
