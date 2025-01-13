package com.sbigeneral.Intimation.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.model.Claims;
import com.sbigeneral.Intimation.model.MainObject;

@Service
public interface MotorIntimationDevApi {
	public ResponseEntity<?> IntimateDevApiService(MainObject obj);

}
