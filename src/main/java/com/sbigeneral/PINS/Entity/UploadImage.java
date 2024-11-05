package com.sbigeneral.PINS.Entity;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class UploadImage {
    
    @JsonProperty("PINNumber")
    private String pinNumber;

    @JsonProperty("decision")
    private String decision;

    @JsonProperty("decisionDate")
    private String decisionDate;
//    private Timestamp
    @JsonProperty("inspectionDate")
    private String inspectionDate;
//    private Timestamp
    @JsonProperty("remarks")
    private String remarks;

    @JsonProperty("Documentsuploaded")
    private String documentsUploaded;

    @JsonProperty("inspectionType")
    private String inspectionType;

    @JsonProperty("documentType")
    private String documentType;

    @JsonProperty("fileName")
    private String fileName;

    @JsonProperty("vehicleDetails")
    private vehicleDetails vehicleDetails;

    public String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(String decisionDate) {
        this.decisionDate = decisionDate;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
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

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public vehicleDetails getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(vehicleDetails vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

	@Override
	public String toString() {
		return "UploadImage [pinNumber=" + pinNumber + ", decision=" + decision + ", decisionDate=" + decisionDate
				+ ", inspectionDate=" + inspectionDate + ", remarks=" + remarks + ", documentsUploaded="
				+ documentsUploaded + ", inspectionType=" + inspectionType + ", documentType=" + documentType
				+ ", fileName=" + fileName + ", vehicleDetails=" + vehicleDetails + "]";
	}

    
    

}