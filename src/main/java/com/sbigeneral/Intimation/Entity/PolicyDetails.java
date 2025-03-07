package com.sbigeneral.Intimation.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="POLICYDETAILS")
public class PolicyDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int Id;
	@Column(name = "POLICYNO")
	private String policyNo;
	
	@Column(name = "CUSTOMERNAME")
	private String customerName;
	
	@Column(name = "EMAILID")
	private String emailID;
	
	@Column(name = "MOBILENO")
	private String mobileNo;
	
	@Column(name = "ALTERNATEMOBILENO")
	private String alternateMobileNo;
	
	@Column(name = "ALTERNATEEMAILID")
	private String alternateEmailId;
	
	@Column(name = "POLICYSTARTDATE")
	private String policyStartDate;
	
	@Column(name = "POLICYENDDATE")
	private String policyEndDate;
	
	@Column(name = "PRODUCTNAME")
	private String productName;
	
	@Column(name = "REGISTRATIONNO")
	private String registrationNo;
	
	@Column(name="DRIVINGLICENSENO")
	private String drivingLicenseNo;
	
	@Column(name="ENGINENO")
	private String engineNo;
	
	@Column(name="CHASISNO")
	private String chasisNo;
	
	@Column(name="LOB")
	private String lob;
	
	@Column(name = "AGREEMENT_CODE")
	private String agreementCode;
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAlternateMobileNo() {
		return alternateMobileNo;
	}

	public void setAlternateMobileNo(String alternateMobileNo) {
		this.alternateMobileNo = alternateMobileNo;
	}

	public String getAlternateEmailId() {
		return alternateEmailId;
	}

	public void setAlternateEmailId(String alternateEmailId) {
		this.alternateEmailId = alternateEmailId;
	}

	public String getPolicyStartDate() {
		return policyStartDate;
	}

	public void setPolicyStartDate(String policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	public String getPolicyEndDate() {
		return policyEndDate;
	}

	public void setPolicyEndDate(String policyEndDate) {
		this.policyEndDate = policyEndDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getDrivingLicenseNo() {
		return drivingLicenseNo;
	}

	public void setDrivingLicenseNo(String drivingLicenseNo) {
		this.drivingLicenseNo = drivingLicenseNo;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getChasisNo() {
		return chasisNo;
	}

	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}
	
	public String getAgreementCode() {
		return agreementCode;
	}

	public void setAgreementCode(String agreementCode) {
		this.agreementCode = agreementCode;
	}

	@Override
	public String toString() {
		return "PolicyDetails [Id=" + Id + ", policyNo=" + policyNo + ", customerName=" + customerName + ", emailID="
				+ emailID + ", mobileNo=" + mobileNo + ", alternateMobileNo=" + alternateMobileNo
				+ ", alternateEmailId=" + alternateEmailId + ", policyStartDate=" + policyStartDate + ", policyEndDate="
				+ policyEndDate + ", productName=" + productName + ", registrationNo=" + registrationNo
				+ ", drivingLicenseNo=" + drivingLicenseNo + ", engineNo=" + engineNo + ", chasisNo=" + chasisNo
				+ ", lob=" + lob + ", agreementCode=" + agreementCode + "]";
	}


	
	

}
