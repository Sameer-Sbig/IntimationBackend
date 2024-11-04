package com.sbigeneral.PINS.ServiceImpl;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.stereotype.Service;

import com.sbigeneral.PINS.Service.Decrypt;


@Service
public class DecryptImpl implements Decrypt{
	
//	private static final String SECRET_KEY = "youraabytekeysaa"; 
//
//	@Override
//	public String decrypt(String encryptedData) throws Exception {
//	    byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
//	    System.out.println(decodedBytes);
//
//	    SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
//
//	    // Use AES with padding (PKCS5Padding)
//	    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//	    cipher.init(Cipher.DECRYPT_MODE, keySpec);
//
//	    byte[] decryptedBytes = cipher.doFinal(decodedBytes);
//	    return new String(decryptedBytes);
//	}
	
	
	 @Override
	    public String decrypt(String encryptedData, String base64Iv, String base64Key) throws Exception {
	        // Decode the base64 encoded key and IV
	        byte[] decodedKey = Base64.getDecoder().decode(base64Key);
	        byte[] decodedIv = Base64.getDecoder().decode(base64Iv);

	        // Convert the key into a SecretKeySpec
	        SecretKeySpec keySpec = new SecretKeySpec(decodedKey, "AES");

	        // Initialize the Cipher with AES/GCM/NoPadding
	        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
	        GCMParameterSpec gcmSpec = new GCMParameterSpec(128, decodedIv); // 128-bit authentication tag length
	        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmSpec);

	        // Decode and decrypt the encrypted data
	        byte[] decodedEncryptedData = Base64.getDecoder().decode(encryptedData);
	        byte[] decryptedBytes = cipher.doFinal(decodedEncryptedData);

	        // Convert decrypted bytes to a string
	        return new String(decryptedBytes, "UTF-8");
	    }


}
