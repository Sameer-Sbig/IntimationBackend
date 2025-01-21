package com.sbigeneral.Intimation.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbigeneral.Intimation.Service.ApiService;
import com.sbigeneral.Intimation.Service.Decrypt;
import io.github.bucket4j.Bucket;

@Controller
@CrossOrigin(origins = { "http://localhost:4200", "https://ansappsuat.sbigen.in", "http://localhost:5173",
		"http://172.18.115.105:7003/PINS", "http://172.16.232.92:7002/PIN", "https://commonsecure.sbigen.in/VBIM/" , "https://uatcld.sbigeneral.in" })
@PropertySource("classpath:log4j2.properties")
public class getPolicyInfoController {

	@Autowired
	private ApiService apiService;

	private static final Logger logger = LogManager.getLogger(getPolicyInfoController.class);

	@Autowired
	Decrypt decryptService;
	@Autowired
	ObjectMapper objectMapper;


	@Autowired
	Bucket bucket;

	@CrossOrigin
	@PostMapping("/getPolicyInfo")
	public ResponseEntity<?> getPolicyInfo(@RequestBody String policyNo) {
		ResponseEntity<?> response;
		System.out.println(policyNo);
		logger.info("Searching data for following policyNo" + policyNo);

		response = apiService.getSecurePolicyInfo(policyNo);
		logger.info(response);

		return response;
	}
}
