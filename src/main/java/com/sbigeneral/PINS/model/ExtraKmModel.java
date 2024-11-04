package com.sbigeneral.PINS.model;
import com.fasterxml.jackson.annotation.JsonProperty;
public class ExtraKmModel {


    @JsonProperty("PINNumber")
    private String pinNumber;

    @JsonProperty("decision")
    private String decision;

    @JsonProperty("remarks")
    private String remarks;

    @JsonProperty("requestedKM")
    private String requestedKm;

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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRequestedKm() {
		return requestedKm;
	}

	public void setRequestedKm(String requestedKm) {
		this.requestedKm = requestedKm;
	}
    
}
