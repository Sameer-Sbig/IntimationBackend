package com.sbigeneral.Intimation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MotorClaimStatusChild1 {

    @JsonProperty("Policy_no")
    private String policyNo;

    @JsonProperty("Alternate_Policy_no")
    private String alternatePolicyNo;

    @JsonProperty("Claim_no")
    private String claimNo;

    @JsonProperty("Vehicle_Registration_Number")
    private String vehicleRegistrationNumber;

    @JsonProperty("requestID") 
   private String requestID;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getAlternatePolicyNo() {
        return alternatePolicyNo;
    }

    public void setAlternatePolicyNo(String alternatePolicyNo) {
        this.alternatePolicyNo = alternatePolicyNo;
    }

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    @Override
    public String toString() {
        return "MotorClaimStatusChild1 [policyNo=" + policyNo + ", alternatePolicyNo=" + alternatePolicyNo
                + ", claimNo=" + claimNo + ", vehicleRegistrationNumber=" + vehicleRegistrationNumber + ", requestID="
                + requestID + "]";
    }

   

    

    

}
