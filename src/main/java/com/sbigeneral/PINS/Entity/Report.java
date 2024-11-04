package com.sbigeneral.PINS.Entity;


import java.sql.Date;

import javax.persistence.*;




@Entity
@Table(name = "TBL_PIN_DETAILS")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "pinnumber")
    private String pinNumber;
    
    @Column(name = "transactionid")
    private String transactionId;

    @Column(name = "source")
    private String source;

    @Column(name = "decision")
    private String decision;

    @Column(name = "decisionDate")
    private Date decisionDate; // Storing date as String

    @Column(name = "inspectionDate")
    private Date inspectionDate; // Storing date as String

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "documentsuploaded")
    private String documentsUploaded;

    @Column(name = "inspectiontype")
    private String inspectionType;

    @Column(name = "vehicleClassification")
    private String vehicleClassification;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Override
	public String toString() {
		return "Report [id=" + id + ", pinNumber=" + pinNumber + ", transactionId=" + transactionId + ", source="
				+ source + ", decision=" + decision + ", decisionDate=" + decisionDate + ", inspectionDate="
				+ inspectionDate + ", remarks=" + remarks + ", documentsUploaded=" + documentsUploaded
				+ ", inspectionType=" + inspectionType + ", vehicleClassification=" + vehicleClassification + ", make="
				+ make + ", model=" + model + ", vehicleSubtype=" + vehicleSubtype + ", regNumberFormat="
				+ regNumberFormat + ", registrationNumber=" + registrationNumber + ", engineNumber=" + engineNumber
				+ ", chassisNumber=" + chassisNumber + ", manufactureYear=" + manufactureYear + ", branchCode="
				+ branchCode + ", branchName=" + branchName + ", vendorCode=" + vendorCode + ", vendorName="
				+ vendorName + ", firstName=" + firstName + ", lastName=" + lastName + ", customerType=" + customerType
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", addressLine1=" + addressLine1
				+ ", districtName=" + districtName + ", cityName=" + cityName + ", stateName=" + stateName + "]";
	}

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Report(int id, String pinNumber, String transactionId, String source, String decision, Date decisionDate,
			Date inspectionDate, String remarks, String documentsUploaded, String inspectionType,
			String vehicleClassification, String make, String model, String vehicleSubtype, String regNumberFormat,
			String registrationNumber, String engineNumber, String chassisNumber, String manufactureYear,
			String branchCode, String branchName, String vendorCode, String vendorName, String firstName,
			String lastName, String customerType, String mobileNumber, String email, String addressLine1,
			String districtName, String cityName, String stateName) {
		super();
		this.id = id;
		this.pinNumber = pinNumber;
		this.transactionId = transactionId;
		this.source = source;
		this.decision = decision;
		this.decisionDate = decisionDate;
		this.inspectionDate = inspectionDate;
		this.remarks = remarks;
		this.documentsUploaded = documentsUploaded;
		this.inspectionType = inspectionType;
		this.vehicleClassification = vehicleClassification;
		this.make = make;
		this.model = model;
		this.vehicleSubtype = vehicleSubtype;
		this.regNumberFormat = regNumberFormat;
		this.registrationNumber = registrationNumber;
		this.engineNumber = engineNumber;
		this.chassisNumber = chassisNumber;
		this.manufactureYear = manufactureYear;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.vendorCode = vendorCode;
		this.vendorName = vendorName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerType = customerType;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.addressLine1 = addressLine1;
		this.districtName = districtName;
		this.cityName = cityName;
		this.stateName = stateName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public Date getDecisionDate() {
		return decisionDate;
	}

	public void setDecisionDate(Date decisionDate) {
		this.decisionDate = decisionDate;
	}

	public Date getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDocumentsUploaded() {
		return documentsUploaded;
	}

	public void setDocumentsUploaded(String documentsUploaded) {
		this.documentsUploaded = documentsUploaded;
	}

	public String getInspectionType() {
		return inspectionType;
	}

	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}

	public String getVehicleClassification() {
		return vehicleClassification;
	}

	public void setVehicleClassification(String vehicleClassification) {
		this.vehicleClassification = vehicleClassification;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVehicleSubtype() {
		return vehicleSubtype;
	}

	public void setVehicleSubtype(String vehicleSubtype) {
		this.vehicleSubtype = vehicleSubtype;
	}

	public String getRegNumberFormat() {
		return regNumberFormat;
	}

	public void setRegNumberFormat(String regNumberFormat) {
		this.regNumberFormat = regNumberFormat;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public String getManufactureYear() {
		return manufactureYear;
	}

	public void setManufactureYear(String manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
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

	@Column(name = "vehicleSubtype")
    private String vehicleSubtype;

    @Column(name = "regnumberformat")
    private String regNumberFormat;

    @Column(name = "registrationnumber")
    private String registrationNumber;

    @Column(name = "enginenumber")
    private String engineNumber;

    @Column(name = "chassisnumber")
    private String chassisNumber;

    @Column(name = "manufactureyear")
    private String manufactureYear;

    @Column(name = "branchCode")
    private String branchCode;

    @Column(name = "branchName")
    private String branchName;

    @Column(name = "vendorCode")
    private String vendorCode;

    @Column(name = "vendorName")
    private String vendorName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "customerType")
    private String customerType;

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "addressLine1")
    private String addressLine1;

    @Column(name = "DistrictName")
    private String districtName;

    @Column(name = "cityName")
    private String cityName;

    @Column(name = "stateName")
    private String stateName;

    // Default constructor
   
}
