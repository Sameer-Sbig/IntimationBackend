package com.sbigeneral.PINS.model;

import java.util.Date;

public class CreditCardLimitPopup {
	
	private String parentCode;
   private String  childcode;
  private String   creditLimit;
  private String  creditPeriod;
  private String  limitStartDate;
   private String limitendDate;
public String getParentCode() {
	return parentCode;
}
public void setParentCode(String parentCode) {
	this.parentCode = parentCode;
}
public String getChildcode() {
	return childcode;
}
public void setChildcode(String childcode) {
	this.childcode = childcode;
}
public String getCreditLimit() {
	return creditLimit;
}
public void setCreditLimit(String creditLimit) {
	this.creditLimit = creditLimit;
}
public String getCreditPeriod() {
	return creditPeriod;
}
public void setCreditPeriod(String creditPeriod) {
	this.creditPeriod = creditPeriod;
}
public String getLimitStartDate() {
	return limitStartDate;
}
public void setLimitStartDate(String limitStartDate) {
	this.limitStartDate = limitStartDate;
}
public String getLimitendDate() {
	return limitendDate;
}
public void setLimitendDate(String limitendDate) {
	this.limitendDate = limitendDate;
}



}
