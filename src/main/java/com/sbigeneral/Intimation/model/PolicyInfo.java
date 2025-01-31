package com.sbigeneral.Intimation.model;

public class PolicyInfo {
	
	private String customerName;
	
	private String customerMobileNo;
	
	private String customerEmailId;
	
	private String policyNo;
	
	private String intimationNo;
	
	private String lob;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobileNo() {
		return customerMobileNo;
	}

	public void setCustomerMobileNo(String customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getIntimationNo() {
		return intimationNo;
	}

	public void setIntimationNo(String intimationNo) {
		this.intimationNo = intimationNo;
	}

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	@Override
	public String toString() {
		return "PolicyInfo [customerName=" + customerName + ", customerMobileNo=" + customerMobileNo
				+ ", customerEmailId=" + customerEmailId + ", policyNo=" + policyNo + ", intimationNo=" + intimationNo
				+ ", lob=" + lob + "]";
	}
	
	
	
}
