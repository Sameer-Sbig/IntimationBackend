package com.sbigeneral.Intimation.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.Entity.HealthClaimIntimation;

@Service
public interface HealthClaimIntimationService {
	
	public ResponseEntity<?> saveHealthClaim(HealthClaimIntimation obj);
}
