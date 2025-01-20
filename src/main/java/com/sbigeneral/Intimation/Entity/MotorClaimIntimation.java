package com.sbigeneral.Intimation.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOTORCLAIMSINTIMATION")
public class MotorClaimIntimation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int Id;
	
	@Column(name = "CLAIMNO")
	private String claimNo;
	
	@Column(name = "STATUSMESSAGE")
	private String StatusMessage;
	@Column(name = "REQUESTID")
	private String requestId;
	@Column(name = "ACTION")
	private String action;
	@Column(name = "CHANNEL")
	private String channel;
	@Column(name = "TRANSACTIONTIMESTAMP")
	private String transactionTimestamp;
	@Column(name = "SERVICETYPE")
	private String serviceType;
	@Column(name = "TIEUPCLAIMID")
	private String tieUpClaimId;
	@Column(name = "USERID")
	private String userId;
	@Column(name = "INSURANCECOMPANY")
	private String insuranceCompany;
	@Column(name = "POLICYNUMBER")
	private String policyNumber;
	@Column(name = "REGISTRATIONNUMBER")
	private String registrationNumber;
	@Column(name = "CONTACTNAME")
	private String contactName;
	@Column(name = "CLAIMSERVICINGBRANCH")
	private String claimServicingBranch;
	@Column(name = "CONTACTNUMBER")
	private String contactNumber;
	@Column(name = "EMAILID")
	private String emailId;
	@Column(name = "ACCIDENTDATEANDTIME")
	private String accidentDateAndTime;
	@Column(name = "ACCIDENTCITY")
	private String accidentCity;
	@Column(name = "VEHICLEINSPECTIONADDRESS")
	private String vehicleInspectionAddress;
	@Column(name = "CITYNAME")
	private String cityName;
	@Column(name = "STATENAME")
	private String stateName;
	@Column(name = "INSPECTIONSPOTLOCATION")
	private String inspectionSpotLocation;
	@Column(name = "GARAGE")
	private String garage;
	@Column(name = "DRIVERNAME")
	private String driverName;
	@Column(name = "ISINSURED")
	private String isInsured;
	@Column(name = "CLAIMINTIMATEDBY")
	private String claimIntimatedBy;
	@Column(name = "CAUSEOFLOSS")
	private String causeOfLoss;
	@Column(name = "OTHERS")
	private String others;
	@Column(name = "ESTIMATEDCLAIMAMOUNT")
	private String estimatedClaimAmount;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getStatusMessage() {
		return StatusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		StatusMessage = statusMessage;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getTransactionTimestamp() {
		return transactionTimestamp;
	}
	public void setTransactionTimestamp(String transactionTimestamp) {
		this.transactionTimestamp = transactionTimestamp;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getTieUpClaimId() {
		return tieUpClaimId;
	}
	public void setTieUpClaimId(String tieUpClaimId) {
		this.tieUpClaimId = tieUpClaimId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getInsuranceCompany() {
		return insuranceCompany;
	}
	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getClaimServicingBranch() {
		return claimServicingBranch;
	}
	public void setClaimServicingBranch(String claimServicingBranch) {
		this.claimServicingBranch = claimServicingBranch;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAccidentDateAndTime() {
		return accidentDateAndTime;
	}
	public void setAccidentDateAndTime(String accidentDateAndTime) {
		this.accidentDateAndTime = accidentDateAndTime;
	}
	public String getAccidentCity() {
		return accidentCity;
	}
	public void setAccidentCity(String accidentCity) {
		this.accidentCity = accidentCity;
	}
	public String getVehicleInspectionAddress() {
		return vehicleInspectionAddress;
	}
	public void setVehicleInspectionAddress(String vehicleInspectionAddress) {
		this.vehicleInspectionAddress = vehicleInspectionAddress;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getInspectionSpotLocation() {
		return inspectionSpotLocation;
	}
	public void setInspectionSpotLocation(String inspectionSpotLocation) {
		this.inspectionSpotLocation = inspectionSpotLocation;
	}
	public String getGarage() {
		return garage;
	}
	public void setGarage(String garage) {
		this.garage = garage;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getIsInsured() {
		return isInsured;
	}
	public void setIsInsured(String isInsured) {
		this.isInsured = isInsured;
	}
	public String getClaimIntimatedBy() {
		return claimIntimatedBy;
	}
	public void setClaimIntimatedBy(String claimIntimatedBy) {
		this.claimIntimatedBy = claimIntimatedBy;
	}
	public String getCauseOfLoss() {
		return causeOfLoss;
	}
	public void setCauseOfLoss(String causeOfLoss) {
		this.causeOfLoss = causeOfLoss;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getEstimatedClaimAmount() {
		return estimatedClaimAmount;
	}
	public void setEstimatedClaimAmount(String estimatedClaimAmount) {
		this.estimatedClaimAmount = estimatedClaimAmount;
	}
	@Override
	public String toString() {
		return "MotorClaimIntimation [Id=" + Id + ", claimNo=" + claimNo + ", StatusMessage=" + StatusMessage
				+ ", requestId=" + requestId + ", action=" + action + ", channel=" + channel + ", transactionTimestamp="
				+ transactionTimestamp + ", serviceType=" + serviceType + ", tieUpClaimId=" + tieUpClaimId + ", userId="
				+ userId + ", insuranceCompany=" + insuranceCompany + ", policyNumber=" + policyNumber
				+ ", registrationNumber=" + registrationNumber + ", contactName=" + contactName
				+ ", claimServicingBranch=" + claimServicingBranch + ", contactNumber=" + contactNumber + ", emailId="
				+ emailId + ", accidentDateAndTime=" + accidentDateAndTime + ", accidentCity=" + accidentCity
				+ ", vehicleInspectionAddress=" + vehicleInspectionAddress + ", cityName=" + cityName + ", stateName="
				+ stateName + ", inspectionSpotLocation=" + inspectionSpotLocation + ", garage=" + garage
				+ ", driverName=" + driverName + ", isInsured=" + isInsured + ", claimIntimatedBy=" + claimIntimatedBy
				+ ", causeOfLoss=" + causeOfLoss + ", others=" + others + ", estimatedClaimAmount="
				+ estimatedClaimAmount + "]";
	}
	
	
	
	
}
