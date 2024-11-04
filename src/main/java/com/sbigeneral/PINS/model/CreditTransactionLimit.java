package com.sbigeneral.PINS.model;

public class CreditTransactionLimit {
	
	private String ParentCode;
	private String ChildCode;
	private String SourceName;
	private String QuoteNo;
	private String PolicyNumber;
	private String Premium;
	public String getParentCode() {
		return ParentCode;
	}
	public void setParentCode(String parentCode) {
		ParentCode = parentCode;
	}
	public String getChildCode() {
		return ChildCode;
	}
	public void setChildCode(String childCode) {
		ChildCode = childCode;
	}
	
	public String getSourceName() {
		return SourceName;
	}
	public void setSourceName(String sourceName) {
		SourceName = sourceName;
	}
	public String getQuoteNo() {
		return QuoteNo;
	}
	public void setQuoteNo(String quoteNo) {
		QuoteNo = quoteNo;
	}
	public String getPolicyNumber() {
		return PolicyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		PolicyNumber = policyNumber;
	}
	public String getPremium() {
		return Premium;
	}
	public void setPremium(String premium) {
		Premium = premium;
	}
	@Override
	public String toString() {
		return "CreditTransactionLimit [ParentCode=" + ParentCode + ", ChildCode=" + ChildCode + ", SourceName="
				+ SourceName + ", QuoteNo=" + QuoteNo + ", PolicyNumber=" + PolicyNumber + ", Premium=" + Premium + "]";
	}
	
	
	
	
	
	

}
