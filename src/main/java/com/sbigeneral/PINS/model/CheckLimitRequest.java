package com.sbigeneral.PINS.model;

public class CheckLimitRequest {
	
	private String SourceName;
	private String ParentCode;
	private String ChildCode;
	
	
	
	
	public String getSourceName() {
		return SourceName;
	}
	public void setSourceName(String sourceName) {
		SourceName = sourceName;
	}
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
	@Override
	public String toString() {
		return "CheckLimitRequest [SourceName=" + SourceName + ", ParentCode=" + ParentCode + ", ChildCode=" + ChildCode
				+ "]";
	}
	
	
	
	

}
