package com.sbigeneral.Intimation.ServiceImpl;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.stereotype.Service;

import com.sbigeneral.Intimation.Service.Decrypt;

@Service
public class DecryptImpl implements Decrypt {

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
//	        byte[] decodedKey = Base64.getDecoder().decode(base64Key);
//	        byte[] decodedIv = Base64.getDecoder().decode(base64Iv);

		// Convert the key into a SecretKeySpec
		SecretKeySpec keySpec = new SecretKeySpec(base64Key.getBytes("UTF-8"), "AES");

		// Initialize the Cipher with AES/GCM/NoPadding
		Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
		GCMParameterSpec gcmSpec = new GCMParameterSpec(128, base64Iv.getBytes()); // 128-bit authentication tag length
		cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmSpec);

		// Decode and decrypt the encrypted data
		byte[] decodedEncryptedData = Base64.getDecoder().decode(encryptedData);
		byte[] decryptedBytes = cipher.doFinal(decodedEncryptedData);

		// Convert decrypted bytes to a string
		return new String(decryptedBytes, "UTF-8");
	}

	@Override
	public String aes256cbcDecrypt(String encryptedData) throws Exception {

		String base64key = "YmYzYzE5OWMyNDcwY2I0NzdkOTA3YjFlMDkxN2MxN2I=";
		String base64Iv = "MkY1MkI3RUI3QzE3OTk2QQ==";

		byte[] decodedKey = Base64.getDecoder().decode(base64key);
		byte[] decodedIv = Base64.getDecoder().decode(base64Iv);

		String IV1 = "2F52B7EB7C17996A";
		String s1 = encryptedData.replace(IV1, "");

		IvParameterSpec ivSpec = new IvParameterSpec(decodedIv);
		SecretKeySpec keySpec = new SecretKeySpec(decodedKey, "AES");

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

		byte[] s2 = Base64.getDecoder().decode(s1);
		byte[] originalPlainText = cipher.doFinal(s2);

		String result = new String(originalPlainText, "UTF-8");

		return result;
	}

}
