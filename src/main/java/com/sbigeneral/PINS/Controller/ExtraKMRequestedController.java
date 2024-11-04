package com.sbigeneral.PINS.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sbigeneral.PINS.Service.ExtraKMRequestedService;
import com.sbigeneral.PINS.Utill.FormValidation;
import com.sbigeneral.PINS.model.ExtraKmModel;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://ansappsuat.sbigen.in", "http://localhost:5173",
		"http://172.18.115.105:7003/PINS" , "http://172.16.232.92:7002/PIN","https://commonsecure.sbigen.in/VBIM/"})
@PropertySource("classpath:log4j2.properties")
public class ExtraKMRequestedController {
	private static final Logger logger = LogManager.getLogger(loginController.class);
	private static RestTemplate restTemplate = new RestTemplate();
	@Autowired
	private FormValidation validation;
	
	@Autowired
	private ExtraKMRequestedService extraKmService;
	
	
	@PostMapping("/extraKmRequested1")
	public ResponseEntity<?> extraKmRequestedMethod1(@RequestBody ExtraKmModel entity) {
		return extraKmService.getExtraKMResponse(entity);
	}
	

}
