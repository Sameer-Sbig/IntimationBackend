package com.sbigeneral.PINS.Utill;


import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;



public class Commons {
	   
	 public static final String DATE_FORMAT = "dd/MM/yyyy";
		public static final String EXTENDED_DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
		public static final int DATE_LENGTH = 10;
		public static final QName SERVICE_NAME = new QName("urn:in.sbigeneral.xml:corporate.edm.entity.atomic.DocumentSearch", "DocSearchService");
		public static final QName HEALTH_CARD_SERVICE_NAME = new QName("urn:healthcardgenerate", "healthcard");
		public static final String SENDER="SOA";
		public static final String RECEIVER="SOA";
		public static final String USER="21777";
		//public static final int ADDRESS_LENGTH = 150;  //Commented by Janhavi as per new change on 15Mar2019
		public static final int ADDRESS_LENGTH = 1000;
		public static final int CUSTID_LENGTH = 16;
		public static final int PHONE_LENGTH = 13;
		public static final int MOBILE_LENGTH = 10;
		public static final int EMAIL_LENGTH = 50;
		public static final int LANDMARK_LENGTH = 100;
		public static final int EIA_LENGTH = 13;
		public static final int KYC_LENGTH = 1;
		public static final int NAME_LENGTH=100;
		public static final int CITY_LENGTH=100;
		public static final String EIA_CHARACTER="not allow alphabetic and alphanumeric";
		
		public static boolean approved(JSONObject getvalues) {
			try {
			if(!(boolean) getvalues.get("panVerificationResponseBody")) {
				
			return true;
			}
			
			return false  ;
		}catch (Exception e){
			return false;
		}
			
		}
		
		public static String maskString(String strText, int start, int end, char maskChar) 
		        throws Exception{
		        
		        if(strText == null || strText.equals(""))
		            return "";
		        
		        if(start < 0)
		            start = 0;
		        
		        if( end > strText.length() )
		            end = strText.length();
		            
		        if(start > end)
		            throw new Exception("End index cannot be greater than start index");
		        
		        int maskLength = end - start;
		        
		        if(maskLength == 0)
		            return strText;
		        
		        StringBuilder sbMaskString = new StringBuilder(maskLength);
		        
		        for(int i = 0; i < maskLength; i++){
		            sbMaskString.append(maskChar);
		        }
		        
		        return strText.substring(0, start) 
		            + sbMaskString.toString() 
		            + strText.substring(start + maskLength);
		    }
		public static String maskNumber(String cardNumber, String mask) { 

			// format the number 
			int index = 0; 
			StringBuilder maskedNumber = new StringBuilder(); 
			for (int i = 0; i < mask.length(); i++) { 
			char c = mask.charAt(i); 
			if (c == '#') { 
			maskedNumber.append(cardNumber.charAt(index)); 
			index++; 
			} else if (c == 'X') { 
			maskedNumber.append(c); 
			index++; 
			} else { 
			maskedNumber.append(c); 
			} 
			} 

			// return the masked number 
			return maskedNumber.toString(); 
			}
		
		public static String removeWhite(String policyNo) {
			// Creating a pattern for whitespaces 
		    Pattern patt = Pattern.compile("[\\s]"); 

		    // Searching patt in s. 
		    Matcher mat = patt.matcher(policyNo); 

		    // Replacing 
		    return mat.replaceAll(""); 
		}
		
		public static String getMsgSubject(String msgSubject,String policyNo){
			 MessageFormat mf = new MessageFormat(msgSubject);
			 msgSubject = mf.format(new Object[] {policyNo});
			 return msgSubject;
		 }

		public static String getMsgSubject(String msgSubject, String userName, String password) {
			 MessageFormat mf = new MessageFormat(msgSubject);
			 msgSubject = mf.format(new Object[] {userName,password});
			 return msgSubject;
		}
		
}
