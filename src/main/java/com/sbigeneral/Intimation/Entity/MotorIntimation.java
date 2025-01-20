package com.sbigeneral.Intimation.Entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOTORCLAIMINTIMATION")
public class MotorIntimation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Column(name = "CLAIMNO")
	private String ClaimNo;
	@Column(name = "POLICYNUMBER")
	private String PolicyNumber;
	@Column(name = "REGISTRATIONNUMBER")
	private String RegistrationNumber;
	@Column(name = "INSUREDNAME")
	private String InsuredName;
	@Column(name = "MOBILENUMBER")
	private String MobileNumber;
	@Column(name = "INSUREDEMAILID")
	private String InsuredEmailId;
	@Column(name = "ACCIDENTDATETIME")
	private String AccidentDateTime;
	@Column(name = "LOSSSTATE")
	private String LossState;
	@Column(name = "LOSSCITY")
	private String LossCity;
	@Column(name = "DRIVERNAME")
	private String DriverName;
	@Column(name = "LOSSDESCRIPTION")
	private String LossDescription;
	@Column(name = "NATUREOFLOSS")
	private String NatureOfLoss;
	@Column(name = "SURVEYPLACEORGARAGENAMEADDRESS")
	private String SurveyPlaceOrGarageNameAddress;
	@Column(name = "WORKSHOPID")
	private String WorkshopId;
	@Column(name = "DRIVINGLICENSENUMBER")
	private String DrivingLicenseNumber;
	@Column(name = "ESTIMATEDCLAIMAMOUNT")
	private String EstimatedClaimAmount;
	@Column(name = "MODEOFINTIMATION")
	private String ModeOfIntimation;
	@Column(name = "INSURANCECOMPANY")
	private String InsuranceComapany;
	@Column(name = "SERVICETYPE")
	private String ServiceType;
	@Column(name = "TIEUPCLAIMID")
	private String TieUpClaimId;
	@Column(name = "USERID")
	private String UserId;
	
	@Column(name="CLAIMSERVICINGBRANCH")
	private String ClaimServicingBranch;
	
}
