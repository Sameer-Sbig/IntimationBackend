package com.sbigeneral.Intimation.ServiceImpl;

import java.io.StringReader;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
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
import org.xml.sax.InputSource;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbigeneral.Intimation.Controller.claimIntimationController;
import com.sbigeneral.Intimation.Entity.MotorClaimIntimation;
import com.sbigeneral.Intimation.Repository.MotorIntimationRepo;
import com.sbigeneral.Intimation.Service.Decrypt;
import com.sbigeneral.Intimation.Service.DevApiTokenService;
import com.sbigeneral.Intimation.Service.Encrypt;
import com.sbigeneral.Intimation.Service.MotorIntimationDevApi;
import com.sbigeneral.Intimation.model.ClaimsWrapper;


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
//	@Override
//	public ResponseEntity<?> IntimateDevApiService(RequestBody obj) {
//		String encryptedData;
//		try {
//			encryptedData = encrypt.encrypt(obj.getClaims(), "05y/Zh9tsXeFAkRCz93poem27hMLV2iX", "VTXb7e2p1iQ=");
//
//			System.out.println("Encrypted data is :" + encryptedData);
//			logger.info("Encrypted data is" + encryptedData);
//			ResponseEntity<Map<String, String>> token = getToken.getToken();
//			System.out.println("The token is " + token.getBody());
//			logger.info("The token is " + token.getBody());
//			Map<String, String> reqBody = new HashMap<String, String>();
//			reqBody.put("ciphertext", encryptedData);
//			String apiUrl = "https://devapi.sbigeneral.in/v1/Motoveys/API1/ICIntimation";
//			HttpHeaders headers = new HttpHeaders();
//			headers.set("X-IBM-Client-Id", "458b817795bad480c5c59e6c424fd285");
//			headers.set("X-IBM-Client-Secret", "51d9ae9279382a4fa6f1becd4c41ca84");
//			headers.set("Authorization", token.getBody().get("accessToken"));
//			HttpEntity<Map<String, String>> entity = new HttpEntity<Map<String, String>>(reqBody, headers);
//			Class<Map<String, String>> responseType = (Class<Map<String, String>>) (Class<?>) Map.class;
//			RestTemplate restTemplate = new RestTemplate();
//			try {
//				ResponseEntity<Map<String, String>> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity,
//						responseType);
//				System.out.println(response);
//				logger.info("The response is " + response);
//				String response2 = decrypt.decrypt(response.getBody().get("ciphertext"),
//						 "VTXb7e2p1iQ=","05y/Zh9tsXeFAkRCz93poem27hMLV2iX");
//				logger.info("The decrypted response is " + response2);
//				ObjectMapper objectMapper = new ObjectMapper();
//				try {
//					 JsonNode rootNode = objectMapper.readTree(response2);
//				      String claimNo = rootNode.path("NewDataSet").path("Table").path("ClaimNo").asText();
//			            System.out.println("Extracted from response ClaimNo: " + claimNo);
////			            MainObject mainObject = objectMapper.readValue(response2, MainObject.class);
//			            RequestBody mainObject = new RequestBody();
//			            MotorIntimation motorIntimation = new MotorIntimation();
//			            motorIntimation.setClaimNo(claimNo);
//			            System.out.println(obj.getClaims().getClaim());
//			            motorIntimation.setPolicyNumber(obj.getClaims().getClaim().getPolicyNumber());
//			            motorIntimation.setRegistrationNumber(obj.getClaims().getClaim().getRegistrationNumber());
//			            motorIntimation.setInsuredName(obj.getClaims().getClaim().getInsuredName());
//		                motorIntimation.setMobileNumber(obj.getClaims().getClaim().getMobileNumber());
//		                motorIntimation.setInsuredEmailId(obj.getClaims().getClaim().getInsuredEmailId());
//		                motorIntimation.setAccidentDateTime(obj.getClaims().getClaim().getAccidentDateTime());
//		                motorIntimation.setLossState(obj.getClaims().getClaim().getLossState());
//		                motorIntimation.setLossCity(obj.getClaims().getClaim().getLossCity());
//		                motorIntimation.setDriverName(obj.getClaims().getClaim().getDriverName());
//		                motorIntimation.setLossDescription(obj.getClaims().getClaim().getLossDescription());
//		                motorIntimation.setNatureOfLoss(obj.getClaims().getClaim().getNatureOfLoss());
//		                motorIntimation.setSurveyPlaceOrGarageNameAddress(obj.getClaims().getClaim().getSurveyPlaceOrGarageNameAddress());
//		                motorIntimation.setWorkshopId(obj.getClaims().getClaim().getWorkshopId());
//		                motorIntimation.setDrivingLicenseNumber(obj.getClaims().getClaim().getDrivingLicenseNumber());
//		                motorIntimation.setEstimatedClaimAmount(obj.getClaims().getClaim().getEstimatedClaimAmount());
//		                motorIntimation.setInsuranceComapany(obj.getClaims().getInsuranceComapany());
//		                motorIntimation.setServiceType(obj.getClaims().getServiceType());
//		                motorIntimation.setTieUpClaimId(obj.getClaims().getTieUpClaimId());
//		                motorIntimation.setUserId(obj.getClaims().getUserId());
//		                motorIntimation.setClaimServicingBranch(obj.getClaims().getClaim().getClaimServicingBranch());
//		                System.out.println("The motor obj is as :" + motorIntimation);
//		                logger.info("The motor obj is " + motorIntimation);
//		                motorIntimationRepo.save(motorIntimation);
//				} catch (Exception e) {
//					// TODO: handle exception
//					e.printStackTrace();
//					System.out.println("Error while exporting claim No" + e);
//					logger.warn("Error while exporting claim No "+e);
//				}
//				System.out.println(response2);
//				return new ResponseEntity<>(response2, HttpStatus.OK);
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				System.out.println(e);
//				logger.warn("The error is in Motoveys service blocks " +e);
//				return new ResponseEntity<>("Error In Motoveys Service", HttpStatus.BAD_GATEWAY);
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			logger.warn("Internal Server Error " + e);
//			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}

	@Override
	public ResponseEntity<?> IntimateChatBotService(ClaimsWrapper obj) {
		// TODO Auto-generated method stub
		ResponseEntity<Map<String, String>> token = getToken.getToken();
		System.out.println("The token is " + token.getBody());
		logger.info("The token is " + token.getBody());
		
		String apiUrl = "https://devapi.sbigeneral.in/customers/v1/chatbot/claimintimation";
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-IBM-Client-Id", "458b817795bad480c5c59e6c424fd285");
		headers.set("X-IBM-Client-Secret", "51d9ae9279382a4fa6f1becd4c41ca84");
		headers.set("Authorization", token.getBody().get("accessToken"));
		HttpEntity<ClaimsWrapper> entity = new HttpEntity<ClaimsWrapper>(obj,headers);
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String,String> responseData = null;
		
		try {
			ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity,
					String.class);
			System.out.println(response);
			logger.info("The response is " + response);
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				  String claimNo = "";
				  String statusMessage="";
				  String responseBody = response.getBody().trim();	
				  
				  System.out.println("The responseBody is " + responseBody);
				  JsonNode rootNode = objectMapper.readTree(responseBody);     
				  String xmlContent = rootNode.path("responseBody").asText();   
				  System.out.println("Extracted XML: " + xmlContent);
				  logger.info("Extracted XML: " +xmlContent);
				   if (xmlContent.startsWith("<")) {
				        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				        DocumentBuilder builder = factory.newDocumentBuilder();
				 
				        try (StringReader stringReader = new StringReader(xmlContent)) {
				            Document document = builder.parse(new InputSource(stringReader));
				            NodeList claimNoNodes = document.getElementsByTagName("ClaimNo");
				            NodeList statusMessageNodes = document.getElementsByTagName("Statusmessage");
				 
				             claimNo = claimNoNodes.item(0).getTextContent();
				             statusMessage = statusMessageNodes.item(0).getTextContent();
				        }
				    } else {
				    	logger.warn("Response is not valid XML");
				        throw new IllegalArgumentException("Response is not valid XML");
				    }
		            System.out.println("Extracted from response ClaimNo: " + claimNo);
		            System.out.println("Extracted from response StatusMessage " + statusMessage);
		            MotorClaimIntimation obj2 = new MotorClaimIntimation();
		            obj2.setClaimNo(claimNo);
		            obj2.setStatusMessage(statusMessage);
		            obj2.setRequestId(obj.getRequestHeader().getRequestId());
		            obj2.setAction(obj.getRequestHeader().getAction());
		            obj2.setChannel(obj.getRequestHeader().getChannel());
		            obj2.setTransactionTimestamp(obj.getRequestHeader().getTransactionTimestamp());
		            obj2.setServiceType(obj.getRequestBody().getClaims().getServiceType());
		            obj2.setTieUpClaimId(obj.getRequestBody().getClaims().getTieUpClaimId());
		            obj2.setUserId(obj.getRequestBody().getClaims().getUserId());
		            obj2.setInsuranceCompany(obj.getRequestBody().getClaims().getInsuranceComapany());
		            obj2.setPolicyNumber(obj.getRequestBody().getClaims().getClaim().getPolicyNumber());
		            obj2.setRegistrationNumber(obj.getRequestBody().getClaims().getClaim().getRegistrationNumber());
		            obj2.setContactName(obj.getRequestBody().getClaims().getClaim().getContactName());
		            obj2.setClaimServicingBranch(obj.getRequestBody().getClaims().getClaim().getClaimServicingBranch());
		            obj2.setContactNumber(obj.getRequestBody().getClaims().getClaim().getContactNumber());
		            obj2.setEmailId(obj.getRequestBody().getClaims().getClaim().getEmailId());
		            obj2.setAccidentDateAndTime(obj.getRequestBody().getClaims().getClaim().getAccidentDateAndTime());
		            obj2.setAccidentCity(obj.getRequestBody().getClaims().getClaim().getAccidentCity());
		            obj2.setVehicleInspectionAddress(obj.getRequestBody().getClaims().getClaim().getVehicleInspectionAddress());
		            obj2.setCityName(obj.getRequestBody().getClaims().getClaim().getCityName());
		            obj2.setStateName(obj.getRequestBody().getClaims().getClaim().getStateName());
		            obj2.setInspectionSpotLocation(obj.getRequestBody().getClaims().getClaim().getInspectionSpotLocation());
		            obj2.setGarage(obj.getRequestBody().getClaims().getClaim().getGarage());
		            obj2.setDriverName(obj.getRequestBody().getClaims().getClaim().getDriverName());
		            obj2.setIsInsured(obj.getRequestBody().getClaims().getClaim().getIsInsured());
		            obj2.setClaimIntimatedBy(obj.getRequestBody().getClaims().getClaim().getClaimIntimatedBy());
		            obj2.setCauseOfLoss(obj.getRequestBody().getClaims().getClaim().getCauseOfLoss());
		            obj2.setOthers(obj.getRequestBody().getClaims().getClaim().getOthers());
		            obj2.setEstimatedClaimAmount(obj.getRequestBody().getClaims().getClaim().getEstimatedClaimAmount());
		            System.out.println("The motor obj is " + obj2);
		            responseData.put("Claim No", claimNo);
		            responseData.put("StatusMessage", statusMessage);
		            logger.info("The motor obj is + " + obj2);
		            motorIntimationRepo.save(obj2);
		            return new ResponseEntity<>(responseData,HttpStatus.OK);
		            
		            
		            
				
			} catch (Exception e) {
				System.out.println(e);
				logger.warn("Error while saving data to our database" , HttpStatus.BAD_REQUEST);
				return new ResponseEntity<>("Error while saving data to our database",HttpStatus.BAD_REQUEST);
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
			logger.warn("The error is in Motoveys service blocks " +e);
			return new ResponseEntity<>("Error In Motoveys Service", HttpStatus.BAD_GATEWAY);

		}
		
		
	}

}
