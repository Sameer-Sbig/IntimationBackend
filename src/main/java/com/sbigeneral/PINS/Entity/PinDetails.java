package com.sbigeneral.PINS.Entity;



public class PinDetails {
	
	   private String PinNumber;
	    private String RegistrationNumber;
	    private String CustomerName;
	    private String MobileNumber;
	    private String EmailId;
	    private String CityName;
	    private String State;
	    private String Decision;
	    
	    
		public PinDetails(String pinNumber, String registrationNumber, String customerName, String mobileNumber,
				String emailId, String cityName, String state, String decision) {
			super();
			PinNumber = pinNumber;
			RegistrationNumber = registrationNumber;
			CustomerName = customerName;
			MobileNumber = mobileNumber;
			EmailId = emailId;
			CityName = cityName;
			State = state;
			Decision = decision;
		}
		public String getPinNumber() {
			return PinNumber;
		}
		public void setPinNumber(String pinNumber) {
			PinNumber = pinNumber;
		}
		public String getRegistrationNumber() {
			return RegistrationNumber;
		}
		public void setRegistrationNumber(String registrationNumber) {
			RegistrationNumber = registrationNumber;
		}
		public String getCustomerName() {
			return CustomerName;
		}
		public void setCustomerName(String customerName) {
			CustomerName = customerName;
		}
		public String getMobileNumber() {
			return MobileNumber;
		}
		public void setMobileNumber(String mobileNumber) {
			MobileNumber = mobileNumber;
		}
		public String getEmailId() {
			return EmailId;
		}
		public void setEmailId(String emailId) {
			EmailId = emailId;
		}
		public String getCityName() {
			return CityName;
		}
		public void setCityName(String cityName) {
			CityName = cityName;
		}
		public String getState() {
			return State;
		}
		public void setState(String state) {
			State = state;
		}
		public String getDecision() {
			return Decision;
		}
		public void setDecision(String decision) {
			Decision = decision;
		}
		@Override
		public String toString() {
			return "PinDetails [PinNumber=" + PinNumber + ", RegistrationNumber=" + RegistrationNumber
					+ ", CustomerName=" + CustomerName + ", MobileNumber=" + MobileNumber + ", EmailId=" + EmailId
					+ ", CityName=" + CityName + ", State=" + State + ", Decision=" + Decision + "]";
		}
		
		
}
