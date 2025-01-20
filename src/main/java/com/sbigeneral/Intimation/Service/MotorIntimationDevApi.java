package com.sbigeneral.Intimation.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.model.Claims;
import com.sbigeneral.Intimation.model.ClaimsWrapper;
import com.sbigeneral.Intimation.model.RequestBody;

@Service
public interface MotorIntimationDevApi {
//	public ResponseEntity<?> IntimateDevApiService(RequestBody obj);
	public ResponseEntity<?> IntimateChatBotService(ClaimsWrapper obj);

}
