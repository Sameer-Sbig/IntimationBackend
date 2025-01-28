package com.sbigeneral.Intimation.Service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface MediTokenService {
	
	public String getMediToken(Map<String , String> encReqBody , String devApiToken);
}
