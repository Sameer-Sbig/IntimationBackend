package com.sbigeneral.Intimation.ServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbigeneral.Intimation.Controller.claimIntimationController;
import com.sbigeneral.Intimation.Service.ClaimStatusService;
import com.sbigeneral.Intimation.Service.DevApiTokenService;
import com.sbigeneral.Intimation.model.ClaimsWrapper;
import com.sbigeneral.Intimation.model.FinalRequestDTO;
import com.sbigeneral.Intimation.model.MotorClaimStatusChild1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClaimStatusServiceImpl implements ClaimStatusService{
    @Autowired
	private DevApiTokenService getToken;
    private static final Logger logger = LogManager.getLogger(claimIntimationController.class);

     @Value("${myapp.getMotorClaimStatus}")
    private String motorClaimStatusUrl;

@Override
public ResponseEntity<?> checkMotorClaimStatus(FinalRequestDTO obj) {
    // TODO Auto-generated method stub
    ResponseEntity<Map<String, String>> token = getToken.getToken();
    System.out.println("The token is " + token.getBody());
    logger.info("The token is " + token.getBody());
    
    HttpHeaders headers = new HttpHeaders();
    headers.set("X-IBM-Client-Id", "458b817795bad480c5c59e6c424fd285");
    headers.set("X-IBM-Client-Secret", "51d9ae9279382a4fa6f1becd4c41ca84");
    headers.set("Authorization", token.getBody().get("accessToken"));
    
    HttpEntity<Object> entity = new HttpEntity<>(obj, headers);
    RestTemplate restTemplate = new RestTemplate();
    
    try {
        ResponseEntity<String> responseEntity = restTemplate.exchange(
            motorClaimStatusUrl, HttpMethod.POST, entity, String.class);
        
        System.out.println(responseEntity.getBody());
        logger.info("The response is " + responseEntity.getBody());
        
        // Parse the JSON response
        // ObjectMapper objectMapper = new ObjectMapper();
        // List<Map<String, Object>> responseData = objectMapper.readValue(
        //     responseEntity.getBody(), new TypeReference<List<Map<String, Object>>>() {});
        
        return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
    } catch (Exception e) {
        e.printStackTrace();
        logger.warn(e);
        return new ResponseEntity<>("Error Occurred in devApi url", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
    // @Override
    // public ResponseEntity<?> checkHealthClaimStatus(Object obj) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'checkHealthClaimStatus'");
    // }

@Override
public ResponseEntity<?> checkMotorStatusCustomerPortal(String claimRefNo) {
	// TODO Auto-generated method stub
	return null;
}

}
