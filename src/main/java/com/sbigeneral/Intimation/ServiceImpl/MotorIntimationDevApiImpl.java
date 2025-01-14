package com.sbigeneral.Intimation.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbigeneral.Intimation.Controller.claimIntimationController;
import com.sbigeneral.Intimation.Entity.MotorIntimation;
import com.sbigeneral.Intimation.Repository.MotorIntimationRepo;
import com.sbigeneral.Intimation.Service.Decrypt;
import com.sbigeneral.Intimation.Service.DevApiTokenService;
import com.sbigeneral.Intimation.Service.Encrypt;
import com.sbigeneral.Intimation.Service.MotorIntimationDevApi;
import com.sbigeneral.Intimation.model.MainObject;


@Service
public class MotorIntimationDevApiImpl implements MotorIntimationDevApi {
	
	@Autowired
	private Encrypt encrypt;
	@Autowired
	private DevApiTokenService getToken;

	@Autowired
	private Decrypt decrypt;
	
	@Autowired
	private MotorIntimationRepo motorIntimationRepo;
	
	private static final Logger logger = LogManager.getLogger(claimIntimationController.class);
	@Override
	public ResponseEntity<?> IntimateDevApiService(MainObject obj) {
		String encryptedData;
		try {
			encryptedData = encrypt.encrypt(obj.getClaims(), "05y/Zh9tsXeFAkRCz93poem27hMLV2iX", "VTXb7e2p1iQ=");

			System.out.println("Encrypted data is :" + encryptedData);
			logger.info("Encrypted data is" + encryptedData);
			ResponseEntity<Map<String, String>> token = getToken.getToken();
			System.out.println("The token is " + token.getBody());
			logger.info("The token is " + token.getBody());
			Map<String, String> reqBody = new HashMap<String, String>();
			reqBody.put("ciphertext", encryptedData);
			String apiUrl = "https://devapi.sbigeneral.in/v1/Motoveys/API1/ICIntimation";
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-IBM-Client-Id", "458b817795bad480c5c59e6c424fd285");
			headers.set("X-IBM-Client-Secret", "51d9ae9279382a4fa6f1becd4c41ca84");
			headers.set("Authorization", token.getBody().get("accessToken"));
			HttpEntity<Map<String, String>> entity = new HttpEntity<Map<String, String>>(reqBody, headers);
			Class<Map<String, String>> responseType = (Class<Map<String, String>>) (Class<?>) Map.class;
			RestTemplate restTemplate = new RestTemplate();
			try {
				ResponseEntity<Map<String, String>> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity,
						responseType);
				System.out.println(response);
				logger.info("The response is " + response);
				String response2 = decrypt.decrypt(response.getBody().get("ciphertext"),
						 "VTXb7e2p1iQ=","05y/Zh9tsXeFAkRCz93poem27hMLV2iX");
				logger.info("The decrypted response is " + response2);
				ObjectMapper objectMapper = new ObjectMapper();
				try {
					 JsonNode rootNode = objectMapper.readTree(response2);
				      String claimNo = rootNode.path("NewDataSet").path("Table").path("ClaimNo").asText();
			            System.out.println("Extracted from response ClaimNo: " + claimNo);
//			            MainObject mainObject = objectMapper.readValue(response2, MainObject.class);
			            MainObject mainObject = new MainObject();
			            MotorIntimation motorIntimation = new MotorIntimation();
			            motorIntimation.setClaimNo(claimNo);
			            System.out.println(obj.getClaims().getClaim());
			            motorIntimation.setPolicyNumber(obj.getClaims().getClaim().getPolicyNumber());
			            motorIntimation.setRegistrationNumber(obj.getClaims().getClaim().getRegistrationNumber());
			            motorIntimation.setInsuredName(obj.getClaims().getClaim().getInsuredName());
		                motorIntimation.setMobileNumber(obj.getClaims().getClaim().getMobileNumber());
		                motorIntimation.setInsuredEmailId(obj.getClaims().getClaim().getInsuredEmailId());
		                motorIntimation.setAccidentDateTime(obj.getClaims().getClaim().getAccidentDateTime());
		                motorIntimation.setLossState(obj.getClaims().getClaim().getLossState());
		                motorIntimation.setLossCity(obj.getClaims().getClaim().getLossCity());
		                motorIntimation.setDriverName(obj.getClaims().getClaim().getDriverName());
		                motorIntimation.setLossDescription(obj.getClaims().getClaim().getLossDescription());
		                motorIntimation.setNatureOfLoss(obj.getClaims().getClaim().getNatureOfLoss());
		                motorIntimation.setSurveyPlaceOrGarageNameAddress(obj.getClaims().getClaim().getSurveyPlaceOrGarageNameAddress());
		                motorIntimation.setWorkshopId(obj.getClaims().getClaim().getWorkshopId());
		                motorIntimation.setDrivingLicenseNumber(obj.getClaims().getClaim().getDrivingLicenseNumber());
		                motorIntimation.setEstimatedClaimAmount(obj.getClaims().getClaim().getEstimatedClaimAmount());
		                motorIntimation.setInsuranceComapany(obj.getClaims().getInsuranceComapany());
		                motorIntimation.setServiceType(obj.getClaims().getServiceType());
		                motorIntimation.setTieUpClaimId(obj.getClaims().getTieUpClaimId());
		                motorIntimation.setUserId(obj.getClaims().getUserId());
		                motorIntimation.setClaimServicingBranch(obj.getClaims().getClaim().getClaimServicingBranch());
		                System.out.println("The motor obj is as :" + motorIntimation);
		                logger.info("The motor obj is " + motorIntimation);
		                motorIntimationRepo.save(motorIntimation);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println("Error while exporting claim No" + e);
					logger.warn("Error while exporting claim No "+e);
				}
				System.out.println(response2);
				return new ResponseEntity<>(response2, HttpStatus.OK);

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				logger.warn("The error is in Motoveys service blocks " +e);
				return new ResponseEntity<>("Error In Motoveys Service", HttpStatus.BAD_GATEWAY);
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.warn("Internal Server Error " + e);
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
