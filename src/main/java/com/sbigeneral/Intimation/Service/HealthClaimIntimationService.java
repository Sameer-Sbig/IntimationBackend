package com.sbigeneral.Intimation.Service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.Entity.HealthClaimIntimation;

@Service
public interface HealthClaimIntimationService {
	
	public String saveHealthClaim(HealthClaimIntimation obj);
	
	public ResponseEntity<?> saveDevApiHealthClaim(HealthClaimIntimation obj);
	
	public List<HealthClaimIntimation> getHealthIntimationPolicies();
	
	public List<HealthClaimIntimation> getHealthIntimationsByRequestId(String requestId);
	
}
