package com.sbigeneral.PINS.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_Vendor_Master")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "VENDORCODE")
	private String employeeId;
	
	@Column(name = "EMAILID")
	private String emailId;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name="MOBILENUMBER")
	private String mobileNumber;
	
	
	@Column(name="SESSIONCOUNT")
	private Integer sessionCount = 0;

    public Integer getSessionCount() {
		return sessionCount;
	}

	public void setSessionCount(Integer sessionCount) {
		this.sessionCount = sessionCount;
	}

	@Column(name = "IS_LOGGED_IN")
	 private boolean isLoggedIn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", employeeId=" + employeeId + ", emailId=" + emailId
				+ ", password=" + password + ", mobileNumber=" + mobileNumber + ", sessionCount=" + sessionCount
				+ ", isLoggedIn=" + isLoggedIn + "]";
	}


	
	
	
	
	
}
