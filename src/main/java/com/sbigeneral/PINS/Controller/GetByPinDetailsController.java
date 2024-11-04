package com.sbigeneral.PINS.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbigeneral.PINS.Entity.PinDetails;
import com.sbigeneral.PINS.Entity.SearchbyPinDetails;
import com.sbigeneral.PINS.Service.ApiService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://ansappsuat.sbigen.in", "http://localhost:5173",
		"http://172.18.115.105:7003/PINS", "http://172.16.232.92:7002/PIN", "https://commonsecure.sbigen.in/VBIM/" })
@PropertySource("classpath:log4j2.properties")
public class GetByPinDetailsController {
	
	@Autowired
	private ApiService apiService;
	
	@PostMapping("/getByPinDetails")
	public ResponseEntity<?> getPinDetails(@RequestBody SearchbyPinDetails pinDetails) {
		System.out.println(pinDetails);
		String pinNumber = pinDetails.getPinNumber();

		ResponseEntity<Map<String, List<PinDetails>>> response = apiService.getByPinDetails(pinNumber);
		return response;
	}
	

}
