package com.sbigeneral.PINS.model;

public class RenewalPolicyDetails {
	
	private Integer Id;
	private String PolicyNumber;
	private String QuoteNumber;
	private String Cutsomername;
	private String MobileNo;
	private String EmailId;
	private String status;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getPolicyNumber() {
		return PolicyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		PolicyNumber = policyNumber;
	}
	public String getQuoteNumber() {
		return QuoteNumber;
	}
	public void setQuoteNumber(String quoteNumber) {
		QuoteNumber = quoteNumber;
	}
	public String getCutsomername() {
		return Cutsomername;
	}
	public void setCutsomername(String cutsomername) {
		Cutsomername = cutsomername;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "RenewalPolicyDetails [Id=" + Id + ", PolicyNumber=" + PolicyNumber + ", QuoteNumber=" + QuoteNumber
				+ ", Cutsomername=" + Cutsomername + ", MobileNo=" + MobileNo + ", EmailId=" + EmailId + ", status="
				+ status + "]";
	}
	
	

}
