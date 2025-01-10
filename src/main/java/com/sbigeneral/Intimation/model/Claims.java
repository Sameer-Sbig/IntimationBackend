package com.sbigeneral.Intimation.model;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Claims {
	
	@JsonProperty("Claim")
	private Claim Claim;
	
	@JsonProperty("InsuranceComapany")
	private String InsuranceComapany;
	
	@JsonProperty("ServiceType")
	private String ServiceType;
	
	@JsonProperty("TieUpClaimId")
	private String TieUpClaimId;
	
	@JsonProperty("UserId")
	private String UserId;

	
	@JsonProperty("Claim")
	public Claim getClaim() {
		return Claim;
	}

	public void setClaim(Claim claim) {
		Claim = claim;
	}

	@JsonProperty("InsuranceComapany")
	public String getInsuranceComapany() {
		return InsuranceComapany;
	}

	public void setInsuranceComapany(String insuranceComapany) {
		InsuranceComapany = insuranceComapany;
	}

	@JsonProperty("ServiceType")
	public String getServiceType() {
		return ServiceType;
	}

	public void setServiceType(String serviceType) {
		ServiceType = serviceType;
	}
	
	@JsonProperty("TieUpClaimId")
	public String getTieUpClaimId() {
		return TieUpClaimId;
	}

	public void setTieUpClaimId(String tieUpClaimId) {
		TieUpClaimId = tieUpClaimId;
	}
	
	@JsonProperty("UserId")
	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	@Override
	public String toString() {
		return "Claims [Claim=" + Claim + ", InsuranceComapany=" + InsuranceComapany + ", ServiceType=" + ServiceType
				+ ", TieUpClaimId=" + TieUpClaimId + ", UserId=" + UserId + "]";
	}
	

	

}
