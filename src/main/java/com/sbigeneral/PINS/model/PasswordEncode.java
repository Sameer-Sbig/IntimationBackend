package com.sbigeneral.PINS.model;

public class PasswordEncode {
	
	private String key;
	private String EncryptedText;
	private String Base64iv;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getEncryptedText() {
		return EncryptedText;
	}
	public void setEncryptedText(String encryptedText) {
		EncryptedText = encryptedText;
	}
	public String getBase64iv() {
		return Base64iv;
	}
	public void setBase64iv(String base64iv) {
		Base64iv = base64iv;
	}
	@Override
	public String toString() {
		return "PasswordEncode [key=" + key + ", EncryptedText=" + EncryptedText + ", Base64iv=" + Base64iv + "]";
	}
	
	

}
