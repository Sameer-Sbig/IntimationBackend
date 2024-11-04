package com.sbigeneral.PINS.model;

import java.util.Date;

public class CreditLimitResponse {

	
	private String Credit_Limit;
	private String Limit_start_Date;
	private String Limit_end_date;
	public String getCredit_Limit() {
		return Credit_Limit;
	}
	
	public String getLimit_start_Date() {
		return Limit_start_Date;
	}

	public void setLimit_start_Date(String limit_start_Date) {
		Limit_start_Date = limit_start_Date;
	}

	public String getLimit_end_date() {
		return Limit_end_date;
	}

	public void setLimit_end_date(String limit_end_date) {
		Limit_end_date = limit_end_date;
	}

	public void setCredit_Limit(String credit_Limit) {
		Credit_Limit = credit_Limit;
	}

	@Override
	public String toString() {
		return "CreditLimitResponse [Credit_Limit=" + Credit_Limit + ", Limit_start_Date=" + Limit_start_Date
				+ ", Limit_end_date=" + Limit_end_date + "]";
	}
	
	
	
}
