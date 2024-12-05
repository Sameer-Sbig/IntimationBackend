package com.sbigeneral.SECUREAPI.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.sbigeneral.SECUREAPI.Service.ApiService;

@Controller
@CrossOrigin(origins = { "http://localhost:4200", "https://ansappsuat.sbigen.in", "http://localhost:5173",
		"http://172.18.115.105:7003/PINS", "http://172.16.232.92:7002/PIN", "https://commonsecure.sbigen.in/VBIM/" })
@PropertySource("classpath:log4j2.properties")
public class fetchDetails {

	@Autowired
	private ApiService apiService;

	private static final Logger logger = LogManager.getLogger(getPolicyInfoController.class);

	@CrossOrigin
	@PostMapping("/getInfo")
	public ResponseEntity<?> getReport(@RequestBody String PolicyNumber) {

		ResponseEntity<?> response = apiService.fetchSecurePolicyInfo(PolicyNumber);
		return response;
	}

}
