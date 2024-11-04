package com.sbigeneral.PINS.Service;

import org.springframework.stereotype.Service;

@Service
public interface Decrypt {
	
	
	 String decrypt(String encryptedData, String base64Iv, String base64Key) throws Exception;

}
