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
	
	@Column(name = "ACCESS_TOKEN")
	private String accessToken;
	
	@Column(name = "MEMBERID")
	private String memeberId;
	
	@Column(name = "PATIENTNAME")
	private String patientName;
	
	@Column(name = "POLICYNO")
	private String policyNo;
	
	@Column(name = "CONTACTNO")
	private int contactNo;
	
	@Column(name = "EMAILADDRESS")
	private String emailAddress;
	
	@Column(name = "DATEOFADMISSION")
	private Date dateOfAdmission;
	
	@Column(name = "HOSPITALNAME")
	private String hospitalName;
	
	@Column(name = "REASONFORHOSPITALISATION")
	private String reasonForHospitalisation;
	
	@Column(name = "DOCTORNAME")
	private String doctorName;
	
	@Column(name = "ESTIMATEDAMOUNT")
	private int estimatedAmount;
	
	@Column(name = "ROOMTYPE")
	private String roomType;
	
	@Column(name = "CLAIMTYPE")
	private String claimType;
	
	@Column(name = "DATEOFDISCHARGE")
	private Date dateOfDischarge;
	
	@Column(name = "REMARK")
	private String remark;
	
	@Column(name = "CASEOFACCIDENT")
	private String caseOfAccident;
	
	@Column(name = "FIRNO")
	private String firNo;
	
	@Column(name = "HOSPITALSTATE")
	private String hospitalState;
	
	@Column(name = "HOSPITALCITY")
	private String hospitalCity;
	
	@Column(name = "HOSPITALPINCODE")
	private String hospitalPinCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getMemeberId() {
		return memeberId;
	}

	public void setMemeberId(String memeberId) {
		this.memeberId = memeberId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(Date dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getReasonForHospitalisation() {
		return reasonForHospitalisation;
	}

	public void setReasonForHospitalisation(String reasonForHospitalisation) {
		this.reasonForHospitalisation = reasonForHospitalisation;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getEstimatedAmount() {
		return estimatedAmount;
	}

	public void setEstimatedAmount(int estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
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

	public String getCaseOfAccident() {
		return caseOfAccident;
	}

	public void setCaseOfAccident(String caseOfAccident) {
		this.caseOfAccident = caseOfAccident;
	}

	public String getFirNo() {
		return firNo;
	}

	public void setFirNo(String firNo) {
		this.firNo = firNo;
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

	@Override
	public String toString() {
		return "HealthClaimIntimation [id=" + id + ", accessToken=" + accessToken + ", memeberId=" + memeberId
				+ ", patientName=" + patientName + ", policyNo=" + policyNo + ", contactNo=" + contactNo
				+ ", emailAddress=" + emailAddress + ", dateOfAdmission=" + dateOfAdmission + ", hospitalName="
				+ hospitalName + ", reasonForHospitalisation=" + reasonForHospitalisation + ", doctorName=" + doctorName
				+ ", estimatedAmount=" + estimatedAmount + ", roomType=" + roomType + ", claimType=" + claimType
				+ ", dateOfDischarge=" + dateOfDischarge + ", remark=" + remark + ", caseOfAccident=" + caseOfAccident
				+ ", firNo=" + firNo + ", hospitalState=" + hospitalState + ", hospitalCity=" + hospitalCity
				+ ", hospitalPinCode=" + hospitalPinCode + "]";
	}
	

		
	
	
	
	
}
