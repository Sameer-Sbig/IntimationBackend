package com.sbigeneral.PINS.model;

public class RenewalRmsModel {
	
	private String Year;
	private String Month;
	private String Days;
	private String Lob;	
	private String productType;
	private String agrementCode;
	private String RenewalDue;
	private String Product;
	private String ChannelType;
	private String IntermediaryNames;
	private String SaleMName;
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getMonth() {
		return Month;
	}
	public void setMonth(String month) {
		Month = month;
	}
	public String getDays() {
		return Days;
	}
	public void setDays(String days) {
		Days = days;
	}
	public String getLob() {
		return Lob;
	}
	public void setLob(String lob) {
		Lob = lob;
	}
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getAgrementCode() {
		return agrementCode;
	}
	public void setAgrementCode(String agrementCode) {
		this.agrementCode = agrementCode;
	}
	
	public String getRenewalDue() {
		return RenewalDue;
	}
	public void setRenewalDue(String renewalDue) {
		RenewalDue = renewalDue;
	}
	public String getProduct() {
		return Product;
	}
	public void setProduct(String product) {
		Product = product;
	}
	public String getChannelType() {
		return ChannelType;
	}
	public void setChannelType(String channelType) {
		ChannelType = channelType;
	}
	public String getIntermediaryNames() {
		return IntermediaryNames;
	}
	public void setIntermediaryNames(String intermediaryNames) {
		IntermediaryNames = intermediaryNames;
	}
	public String getSaleMName() {
		return SaleMName;
	}
	public void setSaleMName(String saleMName) {
		SaleMName = saleMName;
	}
	@Override
	public String toString() {
		return "RenewalRmsModel [Year=" + Year + ", Month=" + Month + ", Days=" + Days + ", Lob=" + Lob + ", productType="
				+ productType+ ", agrementCode=" + agrementCode + "]";
	}
	
	
	
	
	
	
	
	
	

}
