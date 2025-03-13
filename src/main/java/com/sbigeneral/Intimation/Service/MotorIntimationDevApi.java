package com.sbigeneral.Intimation.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.Entity.HealthClaimIntimation;
import com.sbigeneral.Intimation.Entity.MotorClaimIntimation;
import com.sbigeneral.Intimation.model.Claims;
import com.sbigeneral.Intimation.model.ClaimsWrapper;
import com.sbigeneral.Intimation.model.PolicyIntimationInfo;
import com.sbigeneral.Intimation.model.RequestBody;

@Service
public interface MotorIntimationDevApi {
//	public ResponseEntity<?> IntimateDevApiService(RequestBody obj);
	public ResponseEntity<?> IntimateChatBotService(ClaimsWrapper obj);
	
	public List<MotorClaimIntimation> getMotorIntimationPolicies();
	
	public List<MotorClaimIntimation> getMotorIntimationsByRequestId(String requestId);
	
	public ResponseEntity<?> getMotorIntimationDetailsByClaimNo(String claimNo);

	public ResponseEntity<?> getMotorIntimationsByPolicyNo(String policyNumber);

}
