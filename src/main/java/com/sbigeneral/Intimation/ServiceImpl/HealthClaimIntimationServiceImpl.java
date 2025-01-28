package com.sbigeneral.Intimation.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sbigeneral.Intimation.Entity.HealthClaimIntimation;
import com.sbigeneral.Intimation.Repository.HealthClaimIntimationRepo;
import com.sbigeneral.Intimation.Service.Decrypt;
import com.sbigeneral.Intimation.Service.DevApiTokenService;
import com.sbigeneral.Intimation.Service.Encrypt;
import com.sbigeneral.Intimation.Service.HealthClaimIntimationService;
import com.sbigeneral.Intimation.Service.MediTokenService;

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

	@Override
	public ResponseEntity<?> saveHealthClaim(HealthClaimIntimation obj) {
		try {
			healthClaimRepo.save(obj);
			return new ResponseEntity<>("Health Claim Saved Successfully !" , HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			e.getLocalizedMessage();
			return new ResponseEntity<>("Error Ocurred "+e.getLocalizedMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<Map<String, Object>> saveDevApiHealthClaim(HealthClaimIntimation obj) {
		try {
			Map<String, String> mediTokenReqBody = new HashMap<String, String>();
			
			ResponseEntity<Map<String,String>> devApiToken = devApiTokenService.getToken();
			
			mediTokenReqBody.put("EncryptedPayload",
					"Q0khVHD9Fr4mThd5XTHZuJGdoOogNg8yRHcMTj0f1+0kxJLICjhwg0d0vKnPUXJ/bd4HRlUI5noFkZEBXh57hBjk2Ffya97uwHbG3V0fF+99hkiRk2cnW+gNDDOJjs1giv4+xPUbOYiTXJ4AIyllXPoIig2TijQEXbulRbTMtt/RtR3m27tNfQ0U/srd5njiiFCgR9/AAWQ/7BGMZyRxz8oH/rd3NTrEasyRh1guJU06iUWlpl7uUtQFMlizYRF7hn/McjK0YEHYZerLc2zdGA==");

			String mediToken = mediTokenService.getMediToken(mediTokenReqBody , devApiToken.getBody().get("accessToken"));
			
			Map<String,Object> devApiModel = new HashMap<String, Object>();
			
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
			
			System.out.println("Payload Before encryption : "+requestBody);
			
			String encryptedData = encrypt.aes256cbcEncrypt(requestBody);
			Map<String, String> encryptedPayload = new HashMap<String, String>();
			encryptedPayload.put("EncryptedPayload", encryptedData);
			
			System.out.println("Encrypted Payload : "+encryptedPayload);
			String decryptedData = decrypt.aes256cbcDecrypt(encryptedData);
			System.out.println("Decrypted Payload : "+decryptedData);
			
			// calling dev api to intimate claim
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-IBM-Client-Id", "458b817795bad480c5c59e6c424fd285");
			headers.set("X-IBM-Client-Secret","51d9ae9279382a4fa6f1becd4c41ca84");
			headers.set("Authorization",devApiToken.getBody().get("accessToken"));
			final String apiUrl ="https://devapi.sbigeneral.in/ept/intimateClaim";
			HttpEntity<Map<String,String>> entity = new HttpEntity<Map<String,String>>(encryptedPayload,headers);
			Class<Map<String,Object>> responseType = (Class<Map<String,Object>>) (Class<?>) Map.class;
			RestTemplate restTemplate = new RestTemplate();
			
			try {
				ResponseEntity<Map<String,Object>> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity , responseType);
		    	return (ResponseEntity<Map<String, Object>>) new ResponseEntity<>(response.getBody(),HttpStatus.OK);
				
			} catch (Exception e) {
				e.printStackTrace();
				Map<String,Object> error = new HashMap<String, Object>();
				error.put("error", e.getMessage());
				return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return null;

	}
	
	
}
