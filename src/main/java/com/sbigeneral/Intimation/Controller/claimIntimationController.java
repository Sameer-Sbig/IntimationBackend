package com.sbigeneral.Intimation.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbigeneral.Intimation.Entity.HealthClaimIntimation;
import com.sbigeneral.Intimation.Entity.MotorIntimation;
import com.sbigeneral.Intimation.Service.Encrypt;
import com.sbigeneral.Intimation.Service.HealthClaimIntimationService;
import com.sbigeneral.Intimation.Service.MotorIntimationDevApi;
import com.sbigeneral.Intimation.Service.MotorClaimIntimation;
import com.sbigeneral.Intimation.model.Claims;
import com.sbigeneral.Intimation.model.ClaimsWrapper;
import com.sbigeneral.Intimation.model.MainObject;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://ansappsuat.sbigen.in", "http://localhost:5173",
		"http://172.18.115.105:7003/PINS", "http://172.16.232.92:7002/PIN", "https://commonsecure.sbigen.in/VBIM/",
		"https://uatcld.sbigeneral.in" })

@PropertySource("classpath:log4j2.properties")
public class claimIntimationController {
	private static final Logger logger = LogManager.getLogger(getPolicyInfoController.class);

	@Autowired
	private MotorClaimIntimation motorClaimService;

	@Autowired
	private Encrypt encrypt;

	@Autowired
	private HealthClaimIntimationService healthClaimService;

	@Autowired
	private MotorIntimationDevApi motorClaimServiceDevApi;

	@PostMapping("/motorClaimIntimation")
	public ResponseEntity<?> createAIntimation(@RequestBody MotorIntimation object) {

		return motorClaimService.notifyClaim(object);
	}

	@PostMapping("/healthClaimIntimation")
	public ResponseEntity<?> saveHealthClaimIntimation(@RequestBody HealthClaimIntimation obj) {
		return healthClaimService.saveHealthClaim(obj);
	}

	@PostMapping("/motorClaimIntimationMotoveyss")
	public ResponseEntity<?> intimateHealthClaim(@RequestBody MainObject obj) {

		System.out.println("Inside controller");

		System.out.println(obj.getClaims());
//		System.out.println(obj.getInsuranceCompany());
//		return healthClaimServiceDevApi.IntimateDevApiService();

		String encryptedData;
		try {
			encryptedData = encrypt.encrypt(obj.getClaims(), "05y/Zh9tsXeFAkRCz93poem27hMLV2iX", "VTXb7e2p1iQ=");

			System.out.println("Encrypted data is :" + encryptedData);
			return motorClaimServiceDevApi.IntimateDevApiService(obj);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// return null;

	}
	


}
