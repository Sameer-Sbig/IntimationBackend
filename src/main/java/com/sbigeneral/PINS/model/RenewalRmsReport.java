package com.sbigeneral.PINS.model;

public class RenewalRmsReport {
	
	private String POLICY_NO;
	private String CUSTOMER_NAME;
	private String CURRENT_PHONE_NO;
	private String PRIMARY_EMAIL_ID;
	private String POLICY_ISSUE_DATE;
	private String POLICY_START_DATE;
	private String POLICY_EXPIRY_DATE;
	private String POLICY_EXPIRY_MONTH;
	private String PRODUCT_CODE;
	private String PRODUCT_NAME;
	private String PARTY_ID;
	private String QUOTE_NO;
	private String INTERMEDIARY_CODE;
	private String INTERMEDIARY_NAME;
	private String SBIG_BRANCH_NAME;
	private String AGREEMENT_ID;
	private String TOTAL_RENEWAL_PREMIUM;
	public String getPOLICY_NO() {
		return POLICY_NO;
	}
	public void setPOLICY_NO(String pOLICY_NO) {
		POLICY_NO = pOLICY_NO;
	}
	
	public String getPOLICY_ISSUE_DATE() {
		return POLICY_ISSUE_DATE;
	}
	
	public String getINTERMEDIARY_NAME() {
		return INTERMEDIARY_NAME;
	}
	public void setINTERMEDIARY_NAME(String iNTERMEDIARY_NAME) {
		INTERMEDIARY_NAME = iNTERMEDIARY_NAME;
	}
	public String getSBIG_BRANCH_NAME() {
		return SBIG_BRANCH_NAME;
	}
	public void setSBIG_BRANCH_NAME(String sBIG_BRANCH_NAME) {
		SBIG_BRANCH_NAME = sBIG_BRANCH_NAME;
	}
	public void setPOLICY_ISSUE_DATE(String pOLICY_ISSUE_DATE) {
		POLICY_ISSUE_DATE = pOLICY_ISSUE_DATE;
	}
	public String getCUSTOMER_NAME() {
		return CUSTOMER_NAME;
	}
	public void setCUSTOMER_NAME(String cUSTOMER_NAME) {
		CUSTOMER_NAME = cUSTOMER_NAME;
	}
	public String getCURRENT_PHONE_NO() {
		return CURRENT_PHONE_NO;
	}
	public void setCURRENT_PHONE_NO(String cURRENT_PHONE_NO) {
		CURRENT_PHONE_NO = cURRENT_PHONE_NO;
	}
	public String getPRIMARY_EMAIL_ID() {
		return PRIMARY_EMAIL_ID;
	}
	public void setPRIMARY_EMAIL_ID(String pRIMARY_EMAIL_ID) {
		PRIMARY_EMAIL_ID = pRIMARY_EMAIL_ID;
	}
	public String getPOLICY_START_DATE() {
		return POLICY_START_DATE;
	}
	public void setPOLICY_START_DATE(String pOLICY_START_DATE) {
		POLICY_START_DATE = pOLICY_START_DATE;
	}
	public String getPOLICY_EXPIRY_DATE() {
		return POLICY_EXPIRY_DATE;
	}
	public void setPOLICY_EXPIRY_DATE(String pOLICY_EXPIRY_DATE) {
		POLICY_EXPIRY_DATE = pOLICY_EXPIRY_DATE;
	}
	public String getPOLICY_EXPIRY_MONTH() {
		return POLICY_EXPIRY_MONTH;
	}
	public void setPOLICY_EXPIRY_MONTH(String pOLICY_EXPIRY_MONTH) {
		POLICY_EXPIRY_MONTH = pOLICY_EXPIRY_MONTH;
	}
	public String getPRODUCT_CODE() {
		return PRODUCT_CODE;
	}
	public void setPRODUCT_CODE(String pRODUCT_CODE) {
		PRODUCT_CODE = pRODUCT_CODE;
	}
	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}
	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}
	
	public String getPARTY_ID() {
		return PARTY_ID;
	}
	public void setPARTY_ID(String pARTY_ID) {
		PARTY_ID = pARTY_ID;
	}
	public String getQUOTE_NO() {
		return QUOTE_NO;
	}
	public void setQUOTE_NO(String qUOTE_NO) {
		QUOTE_NO = qUOTE_NO;
	}
	
	public String getINTERMEDIARY_CODE() {
		return INTERMEDIARY_CODE;
	}
	public void setINTERMEDIARY_CODE(String iNTERMEDIARY_CODE) {
		INTERMEDIARY_CODE = iNTERMEDIARY_CODE;
	}
	public String getAGREEMENT_ID() {
		return AGREEMENT_ID;
	}
	public void setAGREEMENT_ID(String aGREEMENT_ID) {
		AGREEMENT_ID = aGREEMENT_ID;
	}
	public String getTOTAL_RENEWAL_PREMIUM() {
		return TOTAL_RENEWAL_PREMIUM;
	}
	public void setTOTAL_RENEWAL_PREMIUM(String tOTAL_RENEWAL_PREMIUM) {
		TOTAL_RENEWAL_PREMIUM = tOTAL_RENEWAL_PREMIUM;
	}
	@Override
	public String toString() {
		return "RenewalRmsReport [POLICY_NO=" + POLICY_NO + ", CUSTOMER_NAME=" + CUSTOMER_NAME + ", CURRENT_PHONE_NO="
				+ CURRENT_PHONE_NO + ", PRIMARY_EMAIL_ID=" + PRIMARY_EMAIL_ID + ", POLICY_ISSUE_DATE="
				+ POLICY_ISSUE_DATE + ", POLICY_START_DATE=" + POLICY_START_DATE + ", POLICY_EXPIRY_DATE="
				+ POLICY_EXPIRY_DATE + ", POLICY_EXPIRY_MONTH=" + POLICY_EXPIRY_MONTH + ", PRODUCT_CODE=" + PRODUCT_CODE
				+ ", PRODUCT_NAME=" + PRODUCT_NAME + ", PARTY_ID=" + PARTY_ID + ", QUOTE_NO=" + QUOTE_NO
				+ ", INTERMEDIARY_CODE=" + INTERMEDIARY_CODE + ", AGREEMENT_ID=" + AGREEMENT_ID
				+ ", TOTAL_RENEWAL_PREMIUM=" + TOTAL_RENEWAL_PREMIUM + "]";
	}
	
	
	
	
	
	
	
}
