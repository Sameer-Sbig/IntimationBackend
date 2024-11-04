package com.sbigeneral.PINS.model;

import org.springframework.stereotype.Component;

@Component
public class UserModel {
	
	private String employeeId;
	
	
	private String password;


	public String getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}


	@Override
	public String toString() {
		return "UserModel [employeeId=" + employeeId + ", password=" + password + "]";
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}
