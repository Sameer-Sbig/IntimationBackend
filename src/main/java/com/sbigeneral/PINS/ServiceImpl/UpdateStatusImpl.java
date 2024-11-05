package com.sbigeneral.PINS.ServiceImpl;

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

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.sbigeneral.PINS.Controller.loginController;
import com.sbigeneral.PINS.Entity.UploadImage;
import com.sbigeneral.PINS.Service.UpdateStatusService;
import com.sbigeneral.PINS.Utill.FormValidation;

@Service
public class UpdateStatusImpl implements UpdateStatusService {
	private static RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private FormValidation validation;
    
    @Value("${myapp.updateStatusLink}")
    private String updateStatusLink;

    private static final Logger logger = LogManager.getLogger(loginController.class);

    @Override
    public ResponseEntity<?> updateStatus(UploadImage obj) {
        System.out.println(obj);
        System.out.println(obj.getRemarks());
        boolean valid = validation.checkSpecialChars(obj.getRemarks());

        if (!valid) {
            logger.error("Special characters found in request");

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Special Characters found in remarks field");
            errorResponse.put("pinNumber", obj.getPinNumber());
            errorResponse.put("statusCode", "406");

            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

       
        HttpEntity<UploadImage> requestEntity = new HttpEntity<>(obj, headers);
        System.out.println(updateStatusLink);
        try {
            ResponseEntity<Map<String, String>> responseEntity = restTemplate.exchange(updateStatusLink, HttpMethod.POST,
                    requestEntity, new ParameterizedTypeReference<Map<String, String>>() {});

            return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);

        } catch (HttpClientErrorException e) {
            String errorBody = e.getResponseBodyAsString();
            logger.error("Error response from vendor: {}", errorBody);

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Request Already Submitted");
            errorResponse.put("pinNumber", obj.getPinNumber());
            errorResponse.put("statusCode", "400");
            logger.error(errorResponse);

            return new ResponseEntity<>(errorResponse, HttpStatus.ALREADY_REPORTED);

        } catch (Exception e) {
            logger.error("Internal Server Error: {}", e.getMessage());
            System.out.println(e.getMessage());
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Internal Server Error");
            errorResponse.put("pinNumber", obj.getPinNumber());
            errorResponse.put("statusCode", "500");

            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
