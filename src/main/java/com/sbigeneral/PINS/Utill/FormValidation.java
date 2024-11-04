package com.sbigeneral.PINS.Utill;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;


@Component
public class FormValidation {
	
	public static boolean checkSpecialChars(String Idnumber){
		if(!Idnumber.equals("")) {
		String regex = "(?=[a-zA-Z0-9])[0-9a-zA-Z\\s,./;&-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(Idnumber);
		 if(!m.matches())
			 return false;
		 }
		return true;
	}

}
