package com.sbigeneral.Intimation.ServiceImpl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.sbigeneral.Intimation.Controller.claimIntimationController;
import com.sbigeneral.Intimation.Entity.HealthClaimIntimation;
import com.sbigeneral.Intimation.Repository.HealthClaimIntimationRepo;
import com.sbigeneral.Intimation.Service.Decrypt;
import com.sbigeneral.Intimation.Service.DevApiTokenService;
import com.sbigeneral.Intimation.Service.Encrypt;
import com.sbigeneral.Intimation.Service.HealthClaimIntimationService;
import com.sbigeneral.Intimation.Service.MediTokenService;
import com.sbigeneral.Intimation.model.PolicyIntimationInfo2;

@Service
public class HealthClaimIntimationServiceImpl implements HealthClaimIntimationService {

	@Autowired
	private HealthClaimIntimationRepo healthClaimRepo;

	@Autowired
	private Encrypt encrypt;

	@Autowired
	private Decrypt decrypt;

	@Autowired
	private MediTokenService mediTokenService;

	@Autowired
	private DevApiTokenService devApiTokenService;

	private static final Logger logger = LogManager.getLogger(claimIntimationController.class);

	@Override
	public String saveHealthClaim(HealthClaimIntimation obj) {
		try {
			LocalDate today = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String todayDate = today.format(formatter);
			obj.setDateOfintimation(todayDate);

			healthClaimRepo.save(obj);
			return "Health Claim Saved Successfully in database !";
		} catch (Exception e) {
			System.out.println(e);
			e.getLocalizedMessage();
			return "Error in saving intimation details in database : " + e;
		}

	}

	@Override
	public ResponseEntity<?> saveDevApiHealthClaim(HealthClaimIntimation obj) {
		try {
			Map<String, String> mediTokenReqBody = new HashMap<String, String>();

			ResponseEntity<Map<String, String>> devApiToken = devApiTokenService.getToken();

			mediTokenReqBody.put("EncryptedPayload",
					"Q0khVHD9Fr4mThd5XTHZuJGdoOogNg8yRHcMTj0f1+0kxJLICjhwg0d0vKnPUXJ/bd4HRlUI5noFkZEBXh57hBjk2Ffya97uwHbG3V0fF+99hkiRk2cnW+gNDDOJjs1giv4+xPUbOYiTXJ4AIyllXPoIig2TijQEXbulRbTMtt/RtR3m27tNfQ0U/srd5njiiFCgR9/AAWQ/7BGMZyRxz8oH/rd3NTrEasyRh1guJU06iUWlpl7uUtQFMlizYRF7hn/McjK0YEHYZerLc2zdGA==");

			String mediToken = mediTokenService.getMediToken(mediTokenReqBody,
					devApiToken.getBody().get("accessToken"));

			Map<String, Object> devApiModel = new HashMap<String, Object>();

			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

			Date date = inputFormat.parse(obj.getDateOfAdmission());
			String outputDate = outputFormat.format(date);

			devApiModel.put("ACCESS_TOKEN", mediToken);
			devApiModel.put("MemberId", obj.getMemeberId());
			devApiModel.put("PatientName", obj.getCustomerName());
			devApiModel.put("PolicyNo", obj.getPolicyNumber());
			devApiModel.put("ContactNo", obj.getCustomerMobileNo());
			devApiModel.put("EmailAddress", obj.getCustomerEmailId());
			devApiModel.put("DateOfAdmisssion", outputDate);
			devApiModel.put("HospitalName", obj.getHospitalName());
			devApiModel.put("ReasonForHospitalisation", obj.getAdmissionReason());
			devApiModel.put("DoctorName", obj.getDoctorName());
			devApiModel.put("EstimatedAmount", obj.getClaimAmount());
			devApiModel.put("RoomType", obj.getRoomType());

			Map<String, Object> requestBody = new HashMap<String, Object>();

			Map<String, String> requestHeadervalues = new HashMap<String, String>();
			requestHeadervalues.put("requestID", "123456");
			requestHeadervalues.put("action", "MobileApp_ClaimDetails_Meddi");
			requestHeadervalues.put("channel", "SBIG");
			requestHeadervalues.put("transactionTimestamp", "01-Feb-2018-01:02:02");

			requestBody.put("RequestHeader", requestHeadervalues);
			requestBody.put("RequestBody", devApiModel);

			System.out.println("Payload Before encryption : " + requestBody);

			String encryptedData = encrypt.aes256cbcEncrypt(requestBody);
			Map<String, String> encryptedPayload = new HashMap<String, String>();
			encryptedPayload.put("EncryptedPayload", encryptedData);

			System.out.println("Encrypted Payload : " + encryptedPayload);
//			String decryptedData = decrypt.aes256cbcDecrypt(encryptedData);
//			System.out.println("Decrypted Payload : "+decryptedData);

			// calling dev api to intimate claim
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-IBM-Client-Id", "458b817795bad480c5c59e6c424fd285");
			headers.set("X-IBM-Client-Secret", "51d9ae9279382a4fa6f1becd4c41ca84");
			headers.set("Authorization", devApiToken.getBody().get("accessToken"));
//			final String apiUrl ="https://devapi.sbigeneral.in/ept/intimateClaim";
//			final String apiUrl = "https://devapiintrasec.sbigen.in:9443/ept/intimateClaim";
			final String apiUrl = "http://devapiintra.sbigen.in:8443/ept/intimateClaim";
			HttpEntity<Map<String, String>> entity = new HttpEntity<Map<String, String>>(encryptedPayload, headers);
			Class<Map<String, Object>> responseType = (Class<Map<String, Object>>) (Class<?>) Map.class;
			RestTemplate restTemplate = new RestTemplate();

			try {
				ResponseEntity<Map<String, Object>> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity,
						responseType);
				logger.info("Response got from health intimation : " + response);

				String decryptedData = decrypt.aes256cbcDecrypt((String) response.getBody().get("EncryptedResponse"));
				System.out.println("Decrypted Response : " + decryptedData);
				logger.info("Decrypted responce : " + decryptedData);

				JSONObject jsonObject = new JSONObject(decryptedData);

				if (response.getBody().get("IsSuccess").equals(true)) {
					obj.setIntimationNo(jsonObject.getString("IntimationNo"));
//					obj.setRequestId("123456");
					String healthClaimSaved = saveHealthClaim(obj);
					System.out.println(healthClaimSaved);
					logger.info(healthClaimSaved);
					return new ResponseEntity<String>(decryptedData, HttpStatus.OK);
				} else {
					System.out.println("Error in intimation");
					logger.info("Error in intimation : " + jsonObject.get("ErrorMessage"));
					if (jsonObject.get("ErrorMessage") == null) {
						return new ResponseEntity<String>("Bad Request", HttpStatus.BAD_REQUEST);
					} else {
						return new ResponseEntity<String>("Claim can not be intimated !",
								HttpStatus.INTERNAL_SERVER_ERROR);
					}
				}
			} catch (HttpClientErrorException e) {
				e.printStackTrace();
				logger.info("Error in health intimation : " + e);
				logger.info("Status code : " + e.getStatusCode());
				return new ResponseEntity<String>("Error occured", e.getStatusCode());
			} catch (Exception e) {
				logger.info("Error in health intimation : " + e);
				return new ResponseEntity<>("Error occured", HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception e) {
			logger.info("Error in health intimation : " + e);
			return new ResponseEntity<>("Error occured", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public List<HealthClaimIntimation> getHealthIntimationPolicies() {
		try {
			List<HealthClaimIntimation> healthIntimationPolicies = healthClaimRepo.getHealthIntimationData();
			return healthIntimationPolicies;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error while fetching health intimation policies : " + e);
			return null;
		}
	}

	@Override
	public List<HealthClaimIntimation> getHealthIntimationsByRequestId(String requestId) {
		try {
			List<HealthClaimIntimation> data = healthClaimRepo.getHealthIntimationByRequestId(requestId);
			return data;

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error while fetching health intimation policies by rquest id : " + e);
			return null;
		}
	}

	@Override
	public ResponseEntity<?> saveDevApiHealthClaimSubmit(HealthClaimIntimation obj) {
		try {

			Map<String, String> mediTokenReqBody = new HashMap<String, String>();

			ResponseEntity<Map<String, String>> devApiToken = devApiTokenService.getToken();

			mediTokenReqBody.put("EncryptedPayload",
					"Q0khVHD9Fr4mThd5XTHZuJGdoOogNg8yRHcMTj0f1+0kxJLICjhwg0d0vKnPUXJ/bd4HRlUI5noFkZEBXh57hBjk2Ffya97uwHbG3V0fF+99hkiRk2cnW+gNDDOJjs1giv4+xPUbOYiTXJ4AIyllXPoIig2TijQEXbulRbTMtt/RtR3m27tNfQ0U/srd5njiiFCgR9/AAWQ/7BGMZyRxz8oH/rd3NTrEasyRh1guJU06iUWlpl7uUtQFMlizYRF7hn/McjK0YEHYZerLc2zdGA==");

			String mediToken = mediTokenService.getMediToken(mediTokenReqBody,
					devApiToken.getBody().get("accessToken"));

			Map<String, Object> devApiModel = new HashMap<String, Object>();

			devApiModel.put("ACCESS_TOKEN", mediToken);
			devApiModel.put("PolicyNo", obj.getPolicyNumber());
			devApiModel.put("MemberID", obj.getMemeberId());
			devApiModel.put("MobileNo", obj.getCustomerMobileNo());
			devApiModel.put("EmailId", obj.getCustomerEmailId());
			devApiModel.put("ClaimDateOfAdmission", obj.getDateOfAdmission());
			devApiModel.put("ClaimDateOfDischarge", obj.getDateOfDischarge());
			devApiModel.put("HospName", obj.getHospitalName());
			devApiModel.put("HospAddress", obj.getHospitalAddress());
			if (obj.getHospitalId().equals("")) {
				devApiModel.put("HospID", null);
			} else {
				devApiModel.put("HospID", obj.getHospitalId());
			}
			devApiModel.put("ReasonForHospitalization", obj.getAdmissionReason());
			devApiModel.put("Disease", obj.getDisease());
			devApiModel.put("ClaimAmount", obj.getClaimAmount());
			devApiModel.put("ClaimType", obj.getClaimType());
			devApiModel.put("InsurerClaimNo", null);
			devApiModel.put("MainClaimNo", 0);

			Map<String, Object> fileAttributes = new HashMap<>();
			fileAttributes.put("FileName", "Test.Pdf");
			fileAttributes.put("FilePath", "https://morth.nic.in/sites/default/files/dd12-13_0.pdf");
			fileAttributes.put("FileTags", null);

			ArrayList<Map<String, Object>> claimSubmissionAttachments = new ArrayList<>();
			claimSubmissionAttachments.add(fileAttributes);

			devApiModel.put("ClaimSubmissionAttachments", claimSubmissionAttachments);

			Map<String, Object> requestBody = new HashMap<String, Object>();

			Map<String, String> requestHeadervalues = new HashMap<String, String>();
			requestHeadervalues.put("requestID", obj.getRequestId());
			requestHeadervalues.put("action", "MobileApp_ClaimDetails_Meddi");
			requestHeadervalues.put("channel", "SBIG");
			requestHeadervalues.put("transactionTimestamp", "01-Feb-2018-01:02:02");

			requestBody.put("RequestHeader", requestHeadervalues);
			requestBody.put("RequestBody", devApiModel);
			System.out.println("Request Body : " + requestBody);
			String encryptedData = encrypt.aes256cbcEncrypt(requestBody);
			Map<String, String> encryptedPayload = new HashMap<String, String>();
			encryptedPayload.put("EncryptedPayload", encryptedData);
			System.out.println("Devapi Token : " + devApiToken.getBody().get("accessToken"));
			System.out.println("Encrypted data : " + encryptedData);

			HttpHeaders headers = new HttpHeaders();
			headers.set("X-IBM-Client-Id", "458b817795bad480c5c59e6c424fd285");
			headers.set("X-IBM-Client-Secret", "51d9ae9279382a4fa6f1becd4c41ca84");
			headers.set("Authorization", devApiToken.getBody().get("accessToken"));
			final String apiUrl = "http://devapiintra.sbigen.in:8443/ept/claimsubmitreq";
			HttpEntity<Map<String, String>> entity = new HttpEntity<Map<String, String>>(encryptedPayload, headers);
			Class<Map<String, Object>> responseType = (Class<Map<String, Object>>) (Class<?>) Map.class;
			RestTemplate restTemplate = new RestTemplate();

			try {
				ResponseEntity<Map<String, Object>> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity,
						responseType);
				String decryptedData = decrypt.aes256cbcDecrypt((String) response.getBody().get("EncryptedResponse"));
				logger.info("Decrypted response got from health claim submit : " + decryptedData);

				JSONObject jsonObject = new JSONObject(decryptedData);
				if (jsonObject.getBoolean("IsSuccess") == true) {
					obj.setIntimationNo(jsonObject.getString("ClaimReferenceNo"));
					String healthClaimSaved = saveHealthClaim(obj);
					logger.info(healthClaimSaved);
					return new ResponseEntity<>(decryptedData, HttpStatus.OK);
				} else {
					System.out.println(jsonObject.getString("ErrorMessage"));
					logger.info("Error from devapi claim submit service : " + jsonObject.getString("ErrorMessage"));
					return new ResponseEntity<String>("Error occured", HttpStatus.BAD_REQUEST);
				}
			} catch (HttpClientErrorException e) {
				e.printStackTrace();
				logger.info("Error from health claim submit devapi service : " + e);
				logger.info("Status code : " + e.getStatusCode());
				return new ResponseEntity<String>("Error occured", e.getStatusCode());
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error occured in claim submit : " + e);
			return new ResponseEntity<>("Error occured", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> checkHealthClaimStatus(Map<String,String> obj) {
		try {
			Map<String, String> mediTokenReqBody = new HashMap<String, String>();

			ResponseEntity<Map<String, String>> devApiToken = devApiTokenService.getToken();

			mediTokenReqBody.put("EncryptedPayload",
					"Q0khVHD9Fr4mThd5XTHZuJGdoOogNg8yRHcMTj0f1+0kxJLICjhwg0d0vKnPUXJ/bd4HRlUI5noFkZEBXh57hBjk2Ffya97uwHbG3V0fF+99hkiRk2cnW+gNDDOJjs1giv4+xPUbOYiTXJ4AIyllXPoIig2TijQEXbulRbTMtt/RtR3m27tNfQ0U/srd5njiiFCgR9/AAWQ/7BGMZyRxz8oH/rd3NTrEasyRh1guJU06iUWlpl7uUtQFMlizYRF7hn/McjK0YEHYZerLc2zdGA==");

			String mediToken = mediTokenService.getMediToken(mediTokenReqBody,devApiToken.getBody().get("accessToken"));
			
			Map<String, Object> requestBody = new HashMap<String, Object>();
			Map<String,String> requestBodyValues = new HashMap<String, String>();
			
			requestBodyValues.put("ACCESS_TOKEN", mediToken);
			requestBodyValues.put("ClaimRefNo", obj.get("claimRefNo"));

			Map<String, String> requestHeadervalues = new HashMap<String, String>();
			requestHeadervalues.put("requestID", obj.get("requestId"));
			requestHeadervalues.put("action", "MobileApp_ClaimDetails_Meddi");
			requestHeadervalues.put("channel", "SBIG");
			requestHeadervalues.put("transactionTimestamp", "01-Feb-2018-01:02:02");

			requestBody.put("RequestHeader", requestHeadervalues);
			requestBody.put("RequestBody", requestBodyValues);
			
			String encryptedData = encrypt.aes256cbcEncrypt(requestBody);
			Map<String, String> encryptedPayload = new HashMap<String, String>();
			encryptedPayload.put("EncryptedPayload", encryptedData);
			
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-IBM-Client-Id", "458b817795bad480c5c59e6c424fd285");
			headers.set("X-IBM-Client-Secret", "51d9ae9279382a4fa6f1becd4c41ca84");
			headers.set("Authorization", devApiToken.getBody().get("accessToken"));
			final String apiUrl = "http://devapiintra.sbigen.in:8443/ept/claimdetails";
			HttpEntity<Map<String, String>> entity = new HttpEntity<Map<String, String>>(encryptedPayload, headers);
			Class<Map<String, Object>> responseType = (Class<Map<String, Object>>) (Class<?>) Map.class;
			RestTemplate restTemplate = new RestTemplate();
			
			try {
				ResponseEntity<Map<String, Object>> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity,responseType);
				String decryptedData = decrypt.aes256cbcDecrypt((String) response.getBody().get("EncryptedResponse"));
				logger.info("Decrypted response got from health claim details : " + decryptedData);

				JSONObject jsonObject = new JSONObject(decryptedData);
				if (jsonObject.getBoolean("IsSuccess") == true) {
					JSONArray claimsData = jsonObject.getJSONArray("ClaimsData");
					JSONObject claim = claimsData.getJSONObject(0);
					
					Map<String, String> claimStatus = new HashMap<String, String>();
					claimStatus.put("statusMessage", claim.getString("STATUS"));
					logger.info(claimStatus);
					
					return new ResponseEntity<>(claimStatus,HttpStatus.OK);
				} else {
					logger.info("Error from devapi claim details service : " + jsonObject.getString("ErrorMessage"));
					Map<String, String> claimStatus = new HashMap<String, String>();
					claimStatus.put("statusMessage", jsonObject.getString("ErrorMessage"));
					return new ResponseEntity<>(claimStatus,HttpStatus.OK);
				}
	
			} catch (HttpClientErrorException e) {
				e.printStackTrace();
				logger.info("Error from health claim details devapi service : " + e);
				logger.info("Status code : " + e.getStatusCode());
				return new ResponseEntity<String>("Error occured", e.getStatusCode());
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error occured in claim status : " + e);
			return new ResponseEntity<>("Error occured", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> getHealthIntimationsByPolicyNo(String policyNumber) {
		try {
			List<HealthClaimIntimation> list = healthClaimRepo.getHealthIntimationByPolicyNo(policyNumber);
			if(list.size() == 0) {
				return new ResponseEntity<>("Claims not found against this policy number",HttpStatus.NOT_FOUND);
			} else {
				List<PolicyIntimationInfo2> policyDetails = new ArrayList<>();
				for(HealthClaimIntimation obj:list) {
					PolicyIntimationInfo2 policy = new PolicyIntimationInfo2();
					policy.setClaimStatus("open");
					policy.setIntimationAmount(obj.getClaimAmount());
					policy.setIntimationDate(obj.getDateOfintimation());
					policy.setIntimationNo(obj.getIntimationNo());
					policy.setPolicyNo(obj.getPolicyNumber());
					policy.setLob("Health");

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
