package com.sbigeneral.Intimation.ServiceImpl;

import java.io.StringReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
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
import com.sbigeneral.Intimation.Service.DevApiTokenService;
import com.sbigeneral.Intimation.Service.MotorIntimationDevApi;
import com.sbigeneral.Intimation.model.ClaimsWrapper;
import com.sbigeneral.Intimation.model.PolicyIntimationInfo;
import com.sbigeneral.Intimation.model.PolicyIntimationInfo2;


@Service
public class MotorIntimationDevApiImpl implements MotorIntimationDevApi {
	

	@Autowired
	private DevApiTokenService getToken;
	
	@Autowired
	private MotorIntimationRepo motorIntimationRepo;
	
	private static final Logger logger = LogManager.getLogger(claimIntimationController.class);
	@Override
	public ResponseEntity<?> IntimateChatBotService(ClaimsWrapper obj) {
		// TODO Auto-generated method stub
		ResponseEntity<Map<String, String>> token = getToken.getToken();
		System.out.println("The token is " + token.getBody());
		logger.info("The token is " + token.getBody());
		
		String apiUrl = "https://devapi.sbigeneral.in/customers/v1/chatbot/claimintimation";
//		String apiUrl1 ="https://devapiintrasec.sbigen.in:9443/customers/v1/chatbot/claimintimation";
		String apiUrl1 = "http://devapiintra.sbigen.in:8443/customers/v1/chatbot/claimintimation";
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-IBM-Client-Id", "458b817795bad480c5c59e6c424fd285");
		headers.set("X-IBM-Client-Secret", "51d9ae9279382a4fa6f1becd4c41ca84");
		headers.set("Authorization", token.getBody().get("accessToken"));
		HttpEntity<ClaimsWrapper> entity = new HttpEntity<ClaimsWrapper>(obj,headers);
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String,String> responseData = new HashMap<String, String>();
		
		try {
			ResponseEntity<String> response = restTemplate.exchange(apiUrl1, HttpMethod.POST, entity,
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
		            responseData.put("claimNo", claimNo);
		            responseData.put("statusMessage", statusMessage);
		            logger.info("The motor obj is + " + obj2);
		            System.out.println("The response data is :" + responseData);
		            if(claimNo.length() != 0) {
		            	motorIntimationRepo.save(obj2);
		            	return new ResponseEntity<>(responseData,HttpStatus.OK);
		            } else {
		            	return new ResponseEntity<>("Error Occured",HttpStatus.INTERNAL_SERVER_ERROR);
		            }
		            
		            
		            
				
			} catch (Exception e) {
				System.out.println(e);
				logger.warn("Error while saving data to our database" , HttpStatus.BAD_REQUEST);
				return new ResponseEntity<>("Error while saving data to our database",HttpStatus.BAD_REQUEST);
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
			logger.warn("The error is in Motoveys service blocks " +e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);

		}
		
		
	}
	@Override
	public List<MotorClaimIntimation> getMotorIntimationPolicies() {
		try {
			List<MotorClaimIntimation> motorIntimationPolicies = motorIntimationRepo.getMotorIntimationData();
			return motorIntimationPolicies;	
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error while fetching motor intimation policies : "+e);
			return null;
		}
	}
	@Override
	public List<MotorClaimIntimation> getMotorIntimationsByRequestId(String requestId) {
		try {
			List<MotorClaimIntimation> data = motorIntimationRepo.getMotorIntimationByRequestId(requestId);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error while fetching health intimation policies by rquest id : "+e);
			return null;
		}
	}
	
	@Override
	public ResponseEntity<?> getMotorIntimationDetailsByClaimNo(String claimNo) {
		try {
			MotorClaimIntimation obj = motorIntimationRepo.getMotorIntimationByClaimNo(claimNo);
			PolicyIntimationInfo policyInfoObj = new PolicyIntimationInfo();
			
			DateTimeFormatter originalFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy-HH:mm:ss");
	        DateTimeFormatter targetFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDateTime date = LocalDateTime.parse(obj.getTransactionTimestamp(), originalFormatter);
			String formattedDate = date.format(targetFormatter);
			
			policyInfoObj.setIntimationAmount(Integer.parseInt(obj.getEstimatedClaimAmount()));
			policyInfoObj.setIntimationDate(formattedDate);
			policyInfoObj.setCustomerName(obj.getContactName());
			policyInfoObj.setPolicyNo(obj.getPolicyNumber());
			policyInfoObj.setIntimationNo(obj.getClaimNo());
			policyInfoObj.setLob("Motor");
			
			if(policyInfoObj == null) {
				return new ResponseEntity<>("Details not found against this claim No",HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(policyInfoObj,HttpStatus.OK);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error while fetching health intimation policies by claimNo : "+e);
			return new ResponseEntity<>("Error while fetching policy intimation details",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@Override
	public ResponseEntity<?> getMotorIntimationsByPolicyNo(String policyNumber) {
		try {
			List<MotorClaimIntimation> list = motorIntimationRepo.getMotorIntimationByPolicyNo(policyNumber);
			if(list.size() == 0) {
				return new ResponseEntity<>("Claims not found against this policy number",HttpStatus.NOT_FOUND);
			} else {
				List<PolicyIntimationInfo2> policyDetails = new ArrayList<>();
				for(MotorClaimIntimation obj :list) {
					PolicyIntimationInfo2 policy = new PolicyIntimationInfo2();

					DateTimeFormatter originalFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy-HH:mm:ss");
					DateTimeFormatter targetFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDateTime date = LocalDateTime.parse(obj.getTransactionTimestamp(), originalFormatter);
					String formattedDate = date.format(targetFormatter);

					policy.setClaimStatus("open");
					policy.setIntimationAmount(Integer.parseInt(obj.getEstimatedClaimAmount()));
					policy.setIntimationDate(formattedDate);
					policy.setIntimationNo(obj.getClaimNo());
					policy.setPolicyNo(obj.getPolicyNumber());
					policy.setLob("Motor");

					policyDetails.add(policy);
				}
				return new ResponseEntity<>(policyDetails,HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error occured in claims fetching against policy number "+policyNumber+ " : "+e);
			return new ResponseEntity<>("Unknown Error occured", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
