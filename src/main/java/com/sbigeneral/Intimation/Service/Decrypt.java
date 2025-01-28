package com.sbigeneral.Intimation.Service;

import org.springframework.stereotype.Service;

@Service
public interface Decrypt {
	
	
	 String decrypt(String encryptedData, String base64Iv, String base64Key) throws Exception;
	 
	 String aes256cbcDecrypt(String encryptedData) throws Exception;

}
