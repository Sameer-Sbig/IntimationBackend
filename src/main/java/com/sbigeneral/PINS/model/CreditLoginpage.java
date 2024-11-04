package com.sbigeneral.PINS.model;

public class CreditLoginpage {
	
	private String ClientId;
	private String AgrementCode;
	private String SourceName;
	
	
	public String getClientId() {
		return ClientId;
	}
	public void setClientId(String clientId) {
		ClientId = clientId;
	}
	
	public String getAgrementCode() {
		return AgrementCode;
	}
	public void setAgrementCode(String agrementCode) {
		AgrementCode = agrementCode;
	}
	public String getSourceName() {
		return SourceName;
	}
	public void setSourceName(String sourceName) {
		SourceName = sourceName;
	}
	@Override
	public String toString() {
		return "ClientRequest [ClientId=" + ClientId + ", AgrementCode=" + AgrementCode + ", SourceName=" + SourceName
				+ "]";
	}
	
	
	

}
