package com.sbigeneral.PINS.model;


public class ChangePasswordRequest {
	
	private String username;
	private String Newpassord;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNewpassord() {
		return Newpassord;
	}
	public void setNewpassord(String newpassord) {
		Newpassord = newpassord;
	}
	@Override
	public String toString() {
		return "ChangePasswordRequest [username=" + username + ", Newpassord=" + Newpassord + "]";
	}
	
	

}
