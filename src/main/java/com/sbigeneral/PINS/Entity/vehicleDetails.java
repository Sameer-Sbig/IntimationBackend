package com.sbigeneral.PINS.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class vehicleDetails {
    
    @JsonProperty("vehicleClassification")
    private String vehicleClassification;

    @JsonProperty("make")
    private String make;

    @JsonProperty("model")
    private String model;

    @JsonProperty("vehicleSubtype")
    private String vehicleSubtype;

    @JsonProperty("registrationNumber")
    private String registrationNumber;

    @JsonProperty("engineNumber")
    private String engineeNumber;

    @JsonProperty("chassisNumber")
    private String chassisNumber;

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

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getEngineeNumber() {
        return engineeNumber;
    }

    public void setEngineeNumber(String engineeNumber) {
        this.engineeNumber = engineeNumber;
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

    public String getDocumentFile() {
        return documentFile;
    }

    public void setDocumentFile(String documentFile) {
        this.documentFile = documentFile;
    }

    @JsonProperty("manufactureYear")
    private String manufactureYear;

    @JsonProperty("documentFile")
    private String documentFile;

	@Override
	public String toString() {
		return "vehicleDetails [vehicleClassification=" + vehicleClassification + ", make=" + make + ", model=" + model
				+ ", vehicleSubtype=" + vehicleSubtype + ", registrationNumber=" + registrationNumber
				+ ", engineeNumber=" + engineeNumber + ", chassisNumber=" + chassisNumber + ", manufactureYear="
				+ manufactureYear + ", documentFile=" + documentFile + "]";
	}
    
    
   


}
