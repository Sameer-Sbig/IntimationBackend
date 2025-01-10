package com.sbigeneral.Intimation.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.Entity.MotorIntimation;

@Service
public interface MotorClaimIntimation {
	public ResponseEntity<?> notifyClaim(MotorIntimation object);

}
