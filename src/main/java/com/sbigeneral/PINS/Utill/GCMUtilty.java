package com.sbigeneral.PINS.Utill;
import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;




@Component
public class GCMUtilty {

	 //private static final Logger logger = LogManager.getLogger(GCMController.class);
	
	 @Autowired
	 private Environment environment;
	
	 private static int GCM_TAG_LENGTH = 16;
	 //static byte[] IV = new byte[12];
	 
	// UAT IV
	 private static String IV = "lOFyvdC/IyI=";
	 
//	//Prod(.129) IV
	//private static String IV = "rVGOux4F38k3";
	 
		
	 
	 public String encryptGCM( String textStr) {
		   
		 System.out.println("Inside Encrypt function..");
	    	//logger.info("Inside encryptGCM function..");
	    	
		    try {
		    	
		    	System.out.println("input string is: "+textStr);
	        //	logger.info("input string is: "+textStr);
		    	
		    	String key = environment.getRequiredProperty("constKey");
		    	System.out.println("key from file is: "+key);
		    	
		        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
		      
		        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
		        
		        System.out.println("IV Bytes : " + IV.getBytes());
	           
		        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8 , IV.getBytes());
		        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, gcmParameterSpec);
		 
		        byte[] encryptedByte = cipher.doFinal(textStr.getBytes());
		        
		        String encryptedStr= new String(Base64.encodeBase64String(encryptedByte));
		        //logger.info("Encrypted cipherText data is: "+encryptedStr);
		        
		        //convert to json and send json as responsse
		        /*JSONObject json=new JSONObject();
		        json.put("CipherText", encryptedStr);
		        return json.toString();*/
		        
		        return encryptedStr;
		        
		    } catch (Exception ex) {
		        ex.printStackTrace();
		       // logger.error("Error while GCM-encrypting: " + ex.toString());
	            System.out.println("Error while GCM-encrypting: " + ex.toString());
		    }
		    return null;
		}
	 
	 
		public String decryptGCM(String encrypted) {
			
			System.out.println("Inside Decrypt function..");
	    	//logger.info("Inside decryptGCM function..");
	    	
		    try {
		    	
		    	System.out.println("input string is: "+encrypted);
	        	//logger.info("input string is: "+encrypted);
		    	
		    	String key = environment.getRequiredProperty("constKey");
		    	System.out.println("key from file is: "+key);
		    	
		        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
		 
		        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
		        
		        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8 , IV.getBytes());
		        
		        cipher.init(Cipher.DECRYPT_MODE, skeySpec, gcmParameterSpec);
		        
		        byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
		 
		        String decryptedStr= new String(original);
		       // logger.info("Decrypted data is: "+decryptedStr);
		        
		        return decryptedStr;
		        
		    } catch (Exception ex) {
		        ex.printStackTrace();
		        //logger.error("Error while GCM-decrypting: " + ex.toString());
	            System.out.println("Error while GCM-decrypting: " + ex.toString());
		    }
		 
		    return null;
		}
		
		public String decrypt(String encryptedData, String key, String base64IV) throws Exception {
	        byte[] ciphertext = java.util.Base64.getDecoder().decode(encryptedData);
	        byte[] iv = java.util.Base64.getDecoder().decode(base64IV);
	        byte[] keyBytes = java.util.Base64.getDecoder().decode(key);

	        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
	        System.out.println("IV length : " + iv.length);

	        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
	        GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);

	        cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmSpec);

	        byte[] decrypted = cipher.doFinal(ciphertext);

	        return new String(decrypted, StandardCharsets.UTF_8);
	    }

}

