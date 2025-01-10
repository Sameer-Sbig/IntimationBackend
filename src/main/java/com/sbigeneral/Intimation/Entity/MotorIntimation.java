package com.sbigeneral.Intimation.Entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MotorClaimIntimation")
public class MotorIntimation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String PolicyNumber;
	private String RegistrationNumber;
	private String InsuredName;
	private String MobileNumber;
	private String InsuredEmailId;
	private Timestamp AccidentDateTime;
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
	private String InsuranceComapany;
	private String ServiceType;
	private String TieUpClaimId;
	private String UserId;

	
	
}
