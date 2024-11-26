package com.sbigeneral.SECUREAPI.ServiceImpl;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbigeneral.SECUREAPI.Service.Encrypt;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Service
public class EncryptImpl implements Encrypt {

	 private static final String ALGORITHM = "AES/GCM/NoPadding";
	    private static final int TAG_LENGTH_BIT = 128; // Authentication tag length

	    @Override
	    public String encrypt(Object response, String base64Key, String base64Iv) throws Exception {
	        // Convert the response object to JSON string
	        ObjectMapper objectMapper = new ObjectMapper();
	        String jsonResponse = objectMapper.writeValueAsString(response);

	        // Decode the base64 encoded key and IV
	        byte[] decodedKey = Base64.getDecoder().decode(base64Key);
	        byte[] decodedIv = Base64.getDecoder().decode(base64Iv);

	        // Convert the key into a SecretKeySpec
	        SecretKeySpec keySpec = new SecretKeySpec(decodedKey, "AES");

	        // Initialize the Cipher with AES/GCM/NoPadding
	        Cipher cipher = Cipher.getInstance(ALGORITHM);
	        GCMParameterSpec gcmSpec = new GCMParameterSpec(TAG_LENGTH_BIT, decodedIv);
	        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmSpec);

	        // Encrypt the JSON response
	        byte[] encryptedBytes = cipher.doFinal(jsonResponse.getBytes("UTF-8"));

	        // Encode the encrypted bytes to Base64
	        return Base64.getEncoder().encodeToString(encryptedBytes);
	    }

}
