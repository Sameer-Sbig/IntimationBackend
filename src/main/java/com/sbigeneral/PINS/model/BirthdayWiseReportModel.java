package com.sbigeneral.PINS.model;

public class BirthdayWiseReportModel {
	private int Id;
	private String CustomeName;
	private Long MobileNumber;
	private String EmailId;
	private String agrementCode;
	private String DOB;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getCustomeName() {
		return CustomeName;
	}
	public void setCustomeName(String customeName) {
		CustomeName = customeName;
	}
	public Long getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getAgrementCode() {
		return agrementCode;
	}
	public void setAgrementCode(String agrementCode) {
		this.agrementCode = agrementCode;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	@Override
	public String toString() {
		return "BirthdayWiseReportModel [Id=" + Id + ", CustomeName=" + CustomeName + ", MobileNumber=" + MobileNumber
				+ ", EmailId=" + EmailId + ", agrementCode=" + agrementCode + ", DOB=" + DOB + "]";
	}
	
	
	

}
