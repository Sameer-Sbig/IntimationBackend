package com.sbigeneral.Intimation.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Claim {
	
	
	private String policyNumber;
	private String registrationNumber;
	private String contactName;
	private String claimServicingBranch;
	private String contactNumber;
	private String emailId;
	private String accidentDateAndTime;
	private String accidentCity;
	private String vehicleInspectionAddress;
	private String cityName;
	private String stateName;
	private String inspectionSpotLocation;
	private String garage;
	private String driverName;
	private String isInsured;
	private String claimIntimatedBy;
	private String causeOfLoss;
	private String others;
	private String estimatedClaimAmount;
	
	
	@JsonProperty("PolicyNumber")
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	@JsonProperty("RegistrationNumber")
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	@JsonProperty("ContactName")
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	@JsonProperty("ClaimServicingbranch")
	public String getClaimServicingBranch() {
		return claimServicingBranch;
	}
	public void setClaimServicingBranch(String claimServicingBranch) {
		this.claimServicingBranch = claimServicingBranch;
	}
	@JsonProperty("ContactNumber")
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	@JsonProperty("emailID")
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@JsonProperty("AccidentDateandtime")
	public String getAccidentDateAndTime() {
		return accidentDateAndTime;
	}
	public void setAccidentDateAndTime(String accidentDateAndTime) {
		this.accidentDateAndTime = accidentDateAndTime;
	}
	@JsonProperty("AccidentCity")
	public String getAccidentCity() {
		return accidentCity;
	}
	public void setAccidentCity(String accidentCity) {
		this.accidentCity = accidentCity;
	}
	@JsonProperty("VehicleInspectionAddress")
	public String getVehicleInspectionAddress() {
		return vehicleInspectionAddress;
	}
	public void setVehicleInspectionAddress(String vehicleInspectionAddress) {
		this.vehicleInspectionAddress = vehicleInspectionAddress;
	}
	@JsonProperty("CityName")
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@JsonProperty("StateName")
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	@JsonProperty("InspectionSpotLocation")
	public String getInspectionSpotLocation() {
		return inspectionSpotLocation;
	}
	public void setInspectionSpotLocation(String inspectionSpotLocation) {
		this.inspectionSpotLocation = inspectionSpotLocation;
	}
	@JsonProperty("Garage")
	public String getGarage() {
		return garage;
	}
	public void setGarage(String garage) {
		this.garage = garage;
	}
	@JsonProperty("DriverName")
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	@JsonProperty("isInsured")
	public String getIsInsured() {
		return isInsured;
	}
	public void setIsInsured(String isInsured) {
		this.isInsured = isInsured;
	}
	@JsonProperty("ClaimIntimatedBy")
	public String getClaimIntimatedBy() {
		return claimIntimatedBy;
	}
	public void setClaimIntimatedBy(String claimIntimatedBy) {
		this.claimIntimatedBy = claimIntimatedBy;
	}
	@JsonProperty("CauseOfLoss")
	public String getCauseOfLoss() {
		return causeOfLoss;
	}
	public void setCauseOfLoss(String causeOfLoss) {
		this.causeOfLoss = causeOfLoss;
	}
	@JsonProperty("Others")
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	@JsonProperty("EstimatedClaimAmount")
	public String getEstimatedClaimAmount() {
		return estimatedClaimAmount;
	}
	public void setEstimatedClaimAmount(String estimatedClaimAmount) {
		this.estimatedClaimAmount = estimatedClaimAmount;
	}
	@Override
	public String toString() {
		return "Claim [policyNumber=" + policyNumber + ", registrationNumber=" + registrationNumber + ", contactName="
				+ contactName + ", claimServicingBranch=" + claimServicingBranch + ", contactNumber=" + contactNumber
				+ ", emailId=" + emailId + ", accidentDateAndTime=" + accidentDateAndTime + ", accidentCity="
				+ accidentCity + ", vehicleInspectionAddress=" + vehicleInspectionAddress + ", cityName=" + cityName
				+ ", stateName=" + stateName + ", inspectionSpotLocation=" + inspectionSpotLocation + ", garage="
				+ garage + ", driverName=" + driverName + ", isInsured=" + isInsured + ", claimIntimatedBy="
				+ claimIntimatedBy + ", causeOfLoss=" + causeOfLoss + ", others=" + others + ", estimatedClaimAmount="
				+ estimatedClaimAmount + "]";
	}
	
	
	
	
	
	

}
