package com.sbigeneral.Intimation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Claim {
	
	
	private String PolicyNumber;
	
	private String RegistrationNumber;
	
	private String InsuredName;
	
	private String ClaimServicingBranch;
	
	private String MobileNumber;
	
	private String InsuredEmailId;
	
	private String AccidentDateTime;
	
	private String LossState;
	
	private String LossCity;
	
	private String DriverName;
	
	private String LossDescription;
	
	private String NatureOfLoss;
	
	private String SurveyPlaceOrGarageNameAddress;
	
	private String WorkshopId;
	
	private String DrivingLicenseNumber;
	
	private String EstimatedClaimAmount;
	
	private String ModeOfIntimation;
	@JsonProperty("PolicyNumber")
	public String getPolicyNumber() {
		return PolicyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		PolicyNumber = policyNumber;
	}
	@JsonProperty("RegistrationNumber")
	public String getRegistrationNumber() {
		return RegistrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		RegistrationNumber = registrationNumber;
	}
	@JsonProperty("InsuredName")
	public String getInsuredName() {
		return InsuredName;
	}
	public void setInsuredName(String insuredName) {
		InsuredName = insuredName;
	}
	@JsonProperty("ClaimServicingBranch")
	public String getClaimServicingBranch() {
		return ClaimServicingBranch;
	}
	public void setClaimServicingBranch(String claimServicingBranch) {
		ClaimServicingBranch = claimServicingBranch;
	}
	@JsonProperty("MobileNumber")
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	@JsonProperty("InsuredEmailId")
	public String getInsuredEmailId() {
		return InsuredEmailId;
	}
	public void setInsuredEmailId(String insuredEmailId) {
		InsuredEmailId = insuredEmailId;
	}
	@JsonProperty("AccidentDateTime")
	public String getAccidentDateTime() {
		return AccidentDateTime;
	}
	public void setAccidentDateTime(String accidentDateTime) {
		AccidentDateTime = accidentDateTime;
	}
	@JsonProperty("LossState")
	public String getLossState() {
		return LossState;
	}
	public void setLossState(String lossState) {
		LossState = lossState;
	}
	@JsonProperty("LossCity")
	public String getLossCity() {
		return LossCity;
	}
	public void setLossCity(String lossCity) {
		LossCity = lossCity;
	}
	@JsonProperty("DriverName")
	public String getDriverName() {
		return DriverName;
	}
	public void setDriverName(String driverName) {
		DriverName = driverName;
	}
	@JsonProperty("LossDescription")
	public String getLossDescription() {
		return LossDescription;
	}
	public void setLossDescription(String lossDescription) {
		LossDescription = lossDescription;
	}
	@JsonProperty("NatureOfLoss")
	public String getNatureOfLoss() {
		return NatureOfLoss;
	}
	public void setNatureOfLoss(String natureOfLoss) {
		NatureOfLoss = natureOfLoss;
	}
	@JsonProperty("SurveyPlaceOrGarageNameAddress")
	public String getSurveyPlaceOrGarageNameAddress() {
		return SurveyPlaceOrGarageNameAddress;
	}
	public void setSurveyPlaceOrGarageNameAddress(String surveyPlaceOrGarageNameAddress) {
		SurveyPlaceOrGarageNameAddress = surveyPlaceOrGarageNameAddress;
	}
	@JsonProperty("WorkshopId")
	public String getWorkshopId() {
		return WorkshopId;
	}
	public void setWorkshopId(String workshopId) {
		WorkshopId = workshopId;
	}
	@JsonProperty("DrivingLicenseNumber")
	public String getDrivingLicenseNumber() {
		return DrivingLicenseNumber;
	}
	public void setDrivingLicenseNumber(String drivingLicenseNumber) {
		DrivingLicenseNumber = drivingLicenseNumber;
	}
	@JsonProperty("EstimatedClaimAmount")
	public String getEstimatedClaimAmount() {
		return EstimatedClaimAmount;
	}
	public void setEstimatedClaimAmount(String estimatedClaimAmount) {
		EstimatedClaimAmount = estimatedClaimAmount;
	}
	@JsonProperty("ModeOfIntimation")
	public String getModeOfIntimation() {
		return ModeOfIntimation;
	}
	public void setModeOfIntimation(String modeOfIntimation) {
		ModeOfIntimation = modeOfIntimation;
	}
	@Override
	public String toString() {
		return "Claim [PolicyNumber=" + PolicyNumber + ", RegistrationNumber=" + RegistrationNumber + ", InsuredName="
				+ InsuredName + ", ClaimServicingBranch=" + ClaimServicingBranch + ", MobileNumber=" + MobileNumber
				+ ", InsuredEmailId=" + InsuredEmailId + ", AccidentDateTime=" + AccidentDateTime + ", LossState="
				+ LossState + ", LossCity=" + LossCity + ", DriverName=" + DriverName + ", LossDescription="
				+ LossDescription + ", NatureOfLoss=" + NatureOfLoss + ", SurveyPlaceOrGarageNameAddress="
				+ SurveyPlaceOrGarageNameAddress + ", WorkshopId=" + WorkshopId + ", DrivingLicenseNumber="
				+ DrivingLicenseNumber + ", EstimatedClaimAmount=" + EstimatedClaimAmount + ", ModeOfIntimation="
				+ ModeOfIntimation + "]";
	}
	
	

}
