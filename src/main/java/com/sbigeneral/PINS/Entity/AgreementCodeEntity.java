package com.sbigeneral.PINS.Entity;

import javax.persistence.Entity;


public class AgreementCodeEntity {
	
	private String AgreementCode;
	private String Agent_Name;
	private String AGREEMENT_ID;
	private String AGENT_ID;
	private String Address;
	private String AgeentCreationDate;
	private String MobileNo;
	private String EmailId;
	private String AgentStatus;
	private String creationDate;
	private String License_Expdate;
	private String Status;
	public String getAgreementCode() {
		return AgreementCode;
	}
	public void setAgreementCode(String agreementCode) {
		AgreementCode = agreementCode;
	}
	public String getAgent_Name() {
		return Agent_Name;
	}
	
	public String getAgeentCreationDate() {
		return AgeentCreationDate;
	}
	public void setAgeentCreationDate(String ageentCreationDate) {
		AgeentCreationDate = ageentCreationDate;
	}
	public String getAGREEMENT_ID() {
		return AGREEMENT_ID;
	}
	public void setAGREEMENT_ID(String aGREEMENT_ID) {
		AGREEMENT_ID = aGREEMENT_ID;
	}
	public void setAgent_Name(String agent_Name) {
		Agent_Name = agent_Name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getAgentStatus() {
		return AgentStatus;
	}
	public void setAgentStatus(String agentStatus) {
		AgentStatus = agentStatus;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	
	public String getLicense_Expdate() {
		return License_Expdate;
	}
	public void setLicense_Expdate(String license_Expdate) {
		License_Expdate = license_Expdate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getAGENT_ID() {
		return AGENT_ID;
	}
	public void setAGENT_ID(String aGENT_ID) {
		AGENT_ID = aGENT_ID;
	}
	@Override
	public String toString() {
		return "AgreementCodeEntity [AgreementCode=" + AgreementCode + ", Agent_Name=" + Agent_Name + ", AGREEMENT_ID="
				+ AGREEMENT_ID + ", AGENT_ID=" + AGENT_ID + ", Address=" + Address + ", AgeentCreationDate="
				+ AgeentCreationDate + ", MobileNo=" + MobileNo + ", EmailId=" + EmailId + ", AgentStatus="
				+ AgentStatus + ", creationDate=" + creationDate + ", License_Expdate=" + License_Expdate + ", Status="
				+ Status + "]";
	}
	
	
	
	

}
