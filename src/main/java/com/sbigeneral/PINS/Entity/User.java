package com.sbigeneral.PINS.Entity;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PHS_AGREEMENT_LOGIN_MASTER")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="BMS_LOGIN_DETAILS_ID_SEQ")
	@SequenceGenerator(name="BMS_LOGIN_DETAILS_ID_SEQ", allocationSize=1,sequenceName = "BMS_LOGIN_DETAILS_ID_SEQ")
	@Column(name = "USERID")
	private Integer UserId;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "EMAILID")
	private String email;
	@Column(name = "MOBILENO")
	private String MobileNo;
	@Column(name = "STATUS")
	private String Status;
	@Column(name = "ENCODEPASSWORD")
	private String EncodePassword;
	private String AGREEMENT_ID;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="Role_Tab",joinColumns = @JoinColumn(name="USERID"))
	private Set<String> Role;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "CREATEDBY")
	private String CreatedBy;
	@Column(name = "CREATED_ON")
	private String Created_On;
	@Transient
	private String captcha;
	@Transient
	private String hidden;
	@Transient
	private String image;
	private String flag="Y";
	private String STATUSCODE="N";
	private String EMPLOYEENAME;
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public String getUsername() {
		return username;
	}
	public String getFlag() {
		return flag;
	}
	
	public String getAGREEMENT_ID() {
		return AGREEMENT_ID;
	}
	
	public String getEncodePassword() {
		return EncodePassword;
	}
	public void setEncodePassword(String encodePassword) {
		EncodePassword = encodePassword;
	}
	public void setAGREEMENT_ID(String aGREEMENT_ID) {
		AGREEMENT_ID = aGREEMENT_ID;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Set<String> getRole() {
		return Role;
	}
	public void setRole(Set<String> role) {
		Role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	public String getCreated_On() {
		return Created_On;
	}
	public void setCreated_On(String created_On) {
		Created_On = created_On;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public String getHidden() {
		return hidden;
	}
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getSTATUSCODE() {
		return STATUSCODE;
	}
	public void setSTATUSCODE(String sTATUSCODE) {
		STATUSCODE = sTATUSCODE;
	}
	
	public String getEMPLOYEENAME() {
		return EMPLOYEENAME;
	}
	public void setEMPLOYEENAME(String eMPLOYEENAME) {
		EMPLOYEENAME = eMPLOYEENAME;
	}
	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", username=" + username + ", email=" + email + ", MobileNo=" + MobileNo
				+ ", Status=" + Status + ", EncodePassword=" + EncodePassword + ", AGREEMENT_ID=" + AGREEMENT_ID
				+ ", Role=" + Role + ", password=" + password + ", CreatedBy=" + CreatedBy + ", Created_On="
				+ Created_On + ", captcha=" + captcha + ", hidden=" + hidden + ", image=" + image + ", flag=" + flag
				+ ", STATUSCODE=" + STATUSCODE + ", EMPLOYEENAME=" + EMPLOYEENAME + "]";
	}
	
	

	
}
