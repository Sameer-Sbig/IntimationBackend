package com.sbigeneral.Intimation.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.model.Claims;

@Service
public interface HealthIntimationDevApi {
	public ResponseEntity<?> IntimateDevApiService(String encryptedData);

}
