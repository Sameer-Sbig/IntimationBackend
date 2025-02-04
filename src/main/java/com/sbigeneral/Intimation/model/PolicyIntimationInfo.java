package com.sbigeneral.Intimation.model;

public class PolicyIntimationInfo {
	
	private String customerName;
	
	private int intimationAmount;
	
	private String intimationDate;
	
	private String policyNo;
	
	private String intimationNo;
	
	private String lob;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getIntimationAmount() {
		return intimationAmount;
	}

	public void setIntimationAmount(int intimationAmount) {
		this.intimationAmount = intimationAmount;
	}

	public String getIntimationDate() {
		return intimationDate;
	}

	public void setIntimationDate(String intimationDate) {
		this.intimationDate = intimationDate;
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
		return "PolicyIntimationInfo [customerName=" + customerName + ", intimationAmount=" + intimationAmount
				+ ", intimationDate=" + intimationDate + ", policyNo=" + policyNo + ", intimationNo=" + intimationNo
				+ ", lob=" + lob + "]";
	}

	
	
	
	
}
