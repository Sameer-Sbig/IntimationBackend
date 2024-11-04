package com.sbigeneral.PINS.ServiceImpl;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.sbigeneral.PINS.Controller.loginController;
import com.sbigeneral.PINS.Service.ExtraKMRequestedService;
import com.sbigeneral.PINS.Utill.FormValidation;
import com.sbigeneral.PINS.model.ExtraKmModel;

@Service
public class ExtraKMRequestedServiceImpl implements ExtraKMRequestedService {
	private static RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private FormValidation validation;

    private static final Logger logger = LogManager.getLogger(loginController.class);
    
    @Value("${myapp.extraKmRequestedLink}")
    private String extraKmRequestedLink;

	@Override
	public ResponseEntity<?> getExtraKMResponse(ExtraKmModel entity) {
		
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<ExtraKmModel> requestEntity = new HttpEntity<>(entity, headers);
	    System.out.println(extraKmRequestedLink);
	    try {
	        ResponseEntity<Map<String, String>> responseEntity = restTemplate.exchange(extraKmRequestedLink, HttpMethod.POST,
	                requestEntity, new ParameterizedTypeReference<Map<String, String>>() {});

	  
	        return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);

	    } catch (HttpClientErrorException e) {
	   
	        String errorBody = e.getResponseBodyAsString();
	        logger.error("Error response from vendor: {}", errorBody);

	        
	        Map<String, String> errorResponse = new HashMap<>();
	        errorResponse.put("message", "Request Already Submitted");
	        errorResponse.put("pinNumber", entity.getPinNumber());
	        errorResponse.put("statusCode", "400");
	        logger.info(errorResponse);

	   
	        return new ResponseEntity<>(errorResponse, HttpStatus.ALREADY_REPORTED);

	    } catch (Exception e) {

	        logger.error("Internal Server Error: {}", e.getMessage());
	        Map<String, String> errorResponse = new HashMap<>();
	        errorResponse.put("message", "Internal Server Error");
	        errorResponse.put("pinNumber", entity.getPinNumber());
	        errorResponse.put("statusCode", "500");

	        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
		
	

}
