package com.sbigeneral.PINS.model;

public class DashboardCurrentMonthReport {
	
	
	private Integer Id;
	private String ProductName;
	private String RenewalCount;
	private String Renewed;
	private String RenewalDue;
	private String Expired;
	private String IntermediatoryCode;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getRenewalCount() {
		return RenewalCount;
	}
	public void setRenewalCount(String renewalCount) {
		RenewalCount = renewalCount;
	}
	public String getRenewed() {
		return Renewed;
	}
	public void setRenewed(String renewed) {
		Renewed = renewed;
	}
	public String getRenewalDue() {
		return RenewalDue;
	}
	public void setRenewalDue(String renewalDue) {
		RenewalDue = renewalDue;
	}
	public String getExpired() {
		return Expired;
	}
	public void setExpired(String expired) {
		Expired = expired;
	}
	
	public String getIntermediatoryCode() {
		return IntermediatoryCode;
	}
	public void setIntermediatoryCode(String intermediatoryCode) {
		IntermediatoryCode = intermediatoryCode;
	}
	@Override
	public String toString() {
		return "DashboardCurrentMonthReport [Id=" + Id + ", ProductName=" + ProductName + ", RenewalCount="
				+ RenewalCount + ", Renewed=" + Renewed + ", RenewalDue=" + RenewalDue + ", Expired=" + Expired
				+ ", IntermediatoryCode=" + IntermediatoryCode + "]";
	}
	
	
	
	
	

}
