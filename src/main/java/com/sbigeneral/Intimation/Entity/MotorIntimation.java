package com.sbigeneral.Intimation.Entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOTORCLAIMINTIMATION")
public class MotorIntimation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Column(name = "CLAIMNO")
	private String ClaimNo;
	@Column(name = "POLICYNUMBER")
	private String PolicyNumber;
	@Column(name = "REGISTRATIONNUMBER")
	private String RegistrationNumber;
	@Column(name = "INSUREDNAME")
	private String InsuredName;
	@Column(name = "MOBILENUMBER")
	private String MobileNumber;
	@Column(name = "INSUREDEMAILID")
	private String InsuredEmailId;
	@Column(name = "ACCIDENTDATETIME")
	private String AccidentDateTime;
	@Column(name = "LOSSSTATE")
	private String LossState;
	@Column(name = "LOSSCITY")
	private String LossCity;
	@Column(name = "DRIVERNAME")
	private String DriverName;
	@Column(name = "LOSSDESCRIPTION")
	private String LossDescription;
	@Column(name = "NATUREOFLOSS")
	private String NatureOfLoss;
	@Column(name = "SURVEYPLACEORGARAGENAMEADDRESS")
	private String SurveyPlaceOrGarageNameAddress;
	@Column(name = "WORKSHOPID")
	private String WorkshopId;
	@Column(name = "DRIVINGLICENSENUMBER")
	private String DrivingLicenseNumber;
	@Column(name = "ESTIMATEDCLAIMAMOUNT")
	private String EstimatedClaimAmount;
	@Column(name = "MODEOFINTIMATION")
	private String ModeOfIntimation;
	@Column(name = "INSURANCECOMPANY")
	private String InsuranceComapany;
	@Column(name = "SERVICETYPE")
	private String ServiceType;
	@Column(name = "TIEUPCLAIMID")
	private String TieUpClaimId;
	@Column(name = "USERID")
	private String UserId;
	
	@Column(name="CLAIMSERVICINGBRANCH")
	private String ClaimServicingBranch;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClaimNo() {
		return ClaimNo;
	}

	public void setClaimNo(String claimNo) {
		ClaimNo = claimNo;
	}

	public String getPolicyNumber() {
		return PolicyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		PolicyNumber = policyNumber;
	}

	public String getRegistrationNumber() {
		return RegistrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		RegistrationNumber = registrationNumber;
	}

	public String getInsuredName() {
		return InsuredName;
	}

	public void setInsuredName(String insuredName) {
		InsuredName = insuredName;
	}

	public String getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

	public String getInsuredEmailId() {
		return InsuredEmailId;
	}

	public void setInsuredEmailId(String insuredEmailId) {
		InsuredEmailId = insuredEmailId;
	}

	public String getAccidentDateTime() {
		return AccidentDateTime;
	}

	public void setAccidentDateTime(String accidentDateTime) {
		AccidentDateTime = accidentDateTime;
	}

	public String getLossState() {
		return LossState;
	}

	public void setLossState(String lossState) {
		LossState = lossState;
	}

	public String getLossCity() {
		return LossCity;
	}

	public void setLossCity(String lossCity) {
		LossCity = lossCity;
	}

	public String getDriverName() {
		return DriverName;
	}

	public void setDriverName(String driverName) {
		DriverName = driverName;
	}

	public String getLossDescription() {
		return LossDescription;
	}

	public void setLossDescription(String lossDescription) {
		LossDescription = lossDescription;
	}

	public String getNatureOfLoss() {
		return NatureOfLoss;
	}

	public void setNatureOfLoss(String natureOfLoss) {
		NatureOfLoss = natureOfLoss;
	}

	public String getSurveyPlaceOrGarageNameAddress() {
		return SurveyPlaceOrGarageNameAddress;
	}

	public void setSurveyPlaceOrGarageNameAddress(String surveyPlaceOrGarageNameAddress) {
		SurveyPlaceOrGarageNameAddress = surveyPlaceOrGarageNameAddress;
	}

	public String getWorkshopId() {
		return WorkshopId;
	}

	public void setWorkshopId(String workshopId) {
		WorkshopId = workshopId;
	}

	public String getDrivingLicenseNumber() {
		return DrivingLicenseNumber;
	}

	public void setDrivingLicenseNumber(String drivingLicenseNumber) {
		DrivingLicenseNumber = drivingLicenseNumber;
	}

	public String getEstimatedClaimAmount() {
		return EstimatedClaimAmount;
	}

	public void setEstimatedClaimAmount(String estimatedClaimAmount) {
		EstimatedClaimAmount = estimatedClaimAmount;
	}

	public String getModeOfIntimation() {
		return ModeOfIntimation;
	}

	public void setModeOfIntimation(String modeOfIntimation) {
		ModeOfIntimation = modeOfIntimation;
	}

	public String getInsuranceComapany() {
		return InsuranceComapany;
	}

	public void setInsuranceComapany(String insuranceComapany) {
		InsuranceComapany = insuranceComapany;
	}

	public String getServiceType() {
		return ServiceType;
	}

	public void setServiceType(String serviceType) {
		ServiceType = serviceType;
	}

	public String getTieUpClaimId() {
		return TieUpClaimId;
	}

	public void setTieUpClaimId(String tieUpClaimId) {
		TieUpClaimId = tieUpClaimId;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getClaimServicingBranch() {
		return ClaimServicingBranch;
	}

	public void setClaimServicingBranch(String claimServicingBranch) {
		ClaimServicingBranch = claimServicingBranch;
	}

	@Override
	public String toString() {
		return "MotorIntimation [id=" + id + ", ClaimNo=" + ClaimNo + ", PolicyNumber=" + PolicyNumber
				+ ", RegistrationNumber=" + RegistrationNumber + ", InsuredName=" + InsuredName + ", MobileNumber="
				+ MobileNumber + ", InsuredEmailId=" + InsuredEmailId + ", AccidentDateTime=" + AccidentDateTime
				+ ", LossState=" + LossState + ", LossCity=" + LossCity + ", DriverName=" + DriverName
				+ ", LossDescription=" + LossDescription + ", NatureOfLoss=" + NatureOfLoss
				+ ", SurveyPlaceOrGarageNameAddress=" + SurveyPlaceOrGarageNameAddress + ", WorkshopId=" + WorkshopId
				+ ", DrivingLicenseNumber=" + DrivingLicenseNumber + ", EstimatedClaimAmount=" + EstimatedClaimAmount
				+ ", ModeOfIntimation=" + ModeOfIntimation + ", InsuranceComapany=" + InsuranceComapany
				+ ", ServiceType=" + ServiceType + ", TieUpClaimId=" + TieUpClaimId + ", UserId=" + UserId
				+ ", ClaimServicingBranch=" + ClaimServicingBranch + "]";
	}
	
	
	
	
	
}
