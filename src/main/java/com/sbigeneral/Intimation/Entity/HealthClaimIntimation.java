package com.sbigeneral.Intimation.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HEALTHCLAIMINTIMATION")
public class HealthClaimIntimation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "INTIMATIONNUMBER")
	private String intimationNo;
	
	@Column(name = "MEMBERID")
	private String memeberId;
	
	@Column(name = "CUSTOMERNAME")
	private String customerName;
	
	@Column(name = "POLICYNO")
	private String policyNumber;
	
	@Column(name = "CONTACTNO")
	private String customerMobileNo;
	
	@Column(name = "EMAILADDRESS")
	private String customerEmailId;
	
	@Column(name = "DATEOFADMISSSION")
	private String dateOfAdmission;
	
	@Column(name = "HOSPITALNAME")
	private String hospitalName;
	
	@Column(name = "REASONFORHOSPITALISATION")
	private String admissionReason;
	
	@Column(name = "DOCTORNAME")
	private String doctorName;
	
	@Column(name = "ESTIMATEDAMOUNT")
	private int claimAmount;
	
	@Column(name = "ROOMTYPE")
	private String roomType;
	
	@Column(name = "CLAIMTYPE")
	private String claimType;
	
	@Column(name = "DATEOFDISCHARGE")
	private Date dateOfDischarge;
	
	@Column(name = "REMARK")
	private String remark;
	
	@Column(name = "CASEOFACCIDENT")
	private String isAccidentCase;
	
	@Column(name = "FIRNO")
	private String FIRNo;
	
	@Column(name = "HOSPITALSTATE")
	private String hospitalState;
	
	@Column(name = "HOSPITALCITY")
	private String hospitalCity;
	
	@Column(name = "HOSPITALPINCODE")
	private String hospitalPinCode;

	@Column(name = "ALTERNATECONTACTNO")
	private String customerAlternateMobileNo;
	
	@Column(name = "ALTERNATEEMAILADDRESS")
	private String customerAlternateEmailId;
	
	@Column(name = "PATIENTNAME")
	private String patientName;

	@Column(name = "REQUESTID")
	private String requestId;
	
	@Column(name = "DATEOFINTIMATION")
	private String dateOfintimation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntimationNo() {
		return intimationNo;
	}

	public void setIntimationNo(String intimationNo) {
		this.intimationNo = intimationNo;
	}

	public String getMemeberId() {
		return memeberId;
	}

	public void setMemeberId(String memeberId) {
		this.memeberId = memeberId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
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

	public String getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(String dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getAdmissionReason() {
		return admissionReason;
	}

	public void setAdmissionReason(String admissionReason) {
		this.admissionReason = admissionReason;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(int claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public Date getDateOfDischarge() {
		return dateOfDischarge;
	}

	public void setDateOfDischarge(Date dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsAccidentCase() {
		return isAccidentCase;
	}

	public void setIsAccidentCase(String isAccidentCase) {
		this.isAccidentCase = isAccidentCase;
	}

	public String getFIRNo() {
		return FIRNo;
	}

	public void setFIRNo(String fIRNo) {
		FIRNo = fIRNo;
	}

	public String getHospitalState() {
		return hospitalState;
	}

	public void setHospitalState(String hospitalState) {
		this.hospitalState = hospitalState;
	}

	public String getHospitalCity() {
		return hospitalCity;
	}

	public void setHospitalCity(String hospitalCity) {
		this.hospitalCity = hospitalCity;
	}

	public String getHospitalPinCode() {
		return hospitalPinCode;
	}

	public void setHospitalPinCode(String hospitalPinCode) {
		this.hospitalPinCode = hospitalPinCode;
	}

	public String getCustomerAlternateMobileNo() {
		return customerAlternateMobileNo;
	}

	public void setCustomerAlternateMobileNo(String customerAlternateMobileNo) {
		this.customerAlternateMobileNo = customerAlternateMobileNo;
	}

	public String getCustomerAlternateEmailId() {
		return customerAlternateEmailId;
	}

	public void setCustomerAlternateEmailId(String customerAlternateEmailId) {
		this.customerAlternateEmailId = customerAlternateEmailId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getDateOfintimation() {
		return dateOfintimation;
	}

	public void setDateOfintimation(String dateOfintimation) {
		this.dateOfintimation = dateOfintimation;
	}

	@Override
	public String toString() {
		return "HealthClaimIntimation [id=" + id + ", intimationNo=" + intimationNo + ", memeberId=" + memeberId
				+ ", customerName=" + customerName + ", policyNumber=" + policyNumber + ", customerMobileNo="
				+ customerMobileNo + ", customerEmailId=" + customerEmailId + ", dateOfAdmission=" + dateOfAdmission
				+ ", hospitalName=" + hospitalName + ", admissionReason=" + admissionReason + ", doctorName="
				+ doctorName + ", claimAmount=" + claimAmount + ", roomType=" + roomType + ", claimType=" + claimType
				+ ", dateOfDischarge=" + dateOfDischarge + ", remark=" + remark + ", isAccidentCase=" + isAccidentCase
				+ ", FIRNo=" + FIRNo + ", hospitalState=" + hospitalState + ", hospitalCity=" + hospitalCity
				+ ", hospitalPinCode=" + hospitalPinCode + ", customerAlternateMobileNo=" + customerAlternateMobileNo
				+ ", customerAlternateEmailId=" + customerAlternateEmailId + ", patientName=" + patientName
				+ ", requestId=" + requestId + ", dateOfintimation=" + dateOfintimation + "]";
	}
	
	
	
	
}
