package com.sbigeneral.PINS.model;

import javax.persistence.Column;

public class ParentCreditModel {
	
	private Integer PId;
	private String IMD_PARENT_CODE;
	private String PARENT_CREDIT_LIMIT;
	private String CREDIT_START_DATE;
	private String CREDIT_END_DATE;
	@Column(name = "CUSTOMERNAME")
	private String CustomerName;
	
	private Integer availabaleAmount;
	public Integer getPId() {
		return PId;
	}
	public void setPId(Integer pId) {
		PId = pId;
	}
	public String getIMD_PARENT_CODE() {
		return IMD_PARENT_CODE;
	}
	public void setIMD_PARENT_CODE(String iMD_PARENT_CODE) {
		IMD_PARENT_CODE = iMD_PARENT_CODE;
	}
	public String getPARENT_CREDIT_LIMIT() {
		return PARENT_CREDIT_LIMIT;
	}
	public void setPARENT_CREDIT_LIMIT(String pARENT_CREDIT_LIMIT) {
		PARENT_CREDIT_LIMIT = pARENT_CREDIT_LIMIT;
	}
	public String getCREDIT_START_DATE() {
		return CREDIT_START_DATE;
	}
	public void setCREDIT_START_DATE(String cREDIT_START_DATE) {
		CREDIT_START_DATE = cREDIT_START_DATE;
	}
	public String getCREDIT_END_DATE() {
		return CREDIT_END_DATE;
	}
	public void setCREDIT_END_DATE(String cREDIT_END_DATE) {
		CREDIT_END_DATE = cREDIT_END_DATE;
	}
	
	
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public Integer getAvailabaleAmount() {
		return availabaleAmount;
	}
	public void setAvailabaleAmount(Integer availabaleAmount) {
		this.availabaleAmount = availabaleAmount;
	}
	@Override
	public String toString() {
		return "ParentCreditModel [PId=" + PId + ", IMD_PARENT_CODE=" + IMD_PARENT_CODE + ", PARENT_CREDIT_LIMIT="
				+ PARENT_CREDIT_LIMIT + ", CREDIT_START_DATE=" + CREDIT_START_DATE + ", CREDIT_END_DATE="
				+ CREDIT_END_DATE + ", CustomerName=" + CustomerName + ", availabaleAmount=" + availabaleAmount + "]";
	}
	
	
	
	
	
	

}
