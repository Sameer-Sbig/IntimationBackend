package com.sbigeneral.Intimation.Service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DevApiTokenService {
	public ResponseEntity<Map<String, String>> getToken();

}
